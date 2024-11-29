package org.example.Repository;
import org.example.Model.HasID;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import org.example.Model.*;
/**
 * The DBRepository class is a generic repository for performing CRUD operations on entities
 * that extend the HasID interface. It supports actions like creating, reading, updating, and deleting
 * records from a PostgreSQL database. It uses reflection to map object fields to database columns.
 *
 * @param <T> The type of entity this repository is working with, which extends HasID.
 */
public class DBRepository<T extends HasID> implements IRepository<T> {
    private static final String URL = "jdbc:postgresql://localhost:5432/realestate";
    private static final String USER = "postgres";
    private static final String PASSWORD = "a";
    private final Class<T> type;
    private static final String AGENT_TABLE = "agents";
    private static final String PROPERTY_TABLE = "properties";
    private static final String CONTRACT_TABLE = "contracts";
    private static final String APPOINTMENT_TABLE = "appointments";
    private static final String CLIENT_TABLE = "clients";
    private static final String REVIEW_TABLE = "reviews";
    private static final String CLIENT_PREFERENCES_TABLE = "client_preferences";
    /**
     * Constructor for DBRepository.
     * Initializes the repository with a specific entity type.
     *
     * @param type The class type of the entity this repository will manage.
     */
    public DBRepository(Class<T> type) {
        this.type = type;
    }
    /**
     * Establishes and returns a connection to the PostgreSQL database.
     *
     * @return A {@link Connection} object used to interact with the database.
     * @throws SQLException if there is an error establishing the connection.
     */
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    /**
     * Creates a new entity record in the database based on the provided object.
     *
     * @param obj The object representing the entity to be inserted into the database.
     */
    @Override
    public void create(T obj) {
        String sql = generateInsertSQL(obj);

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            setInsertParameters(statement, obj);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Reads an entity from the database by its ID.
     *
     * @param id The ID of the entity to be fetched from the database.
     * @return The entity corresponding to the given ID, or null if not found.
     */
    @Override
    public T read(Integer id) {
        String tableName = getTableName();
        String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToObject(resultSet);
            }
        } catch (SQLException | ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * Updates an existing entity record in the database based on the provided object.
     *
     * @param obj The object containing the updated values to be applied to the database record.
     */
    @Override
    public void update(T obj) {
        String sql = generateUpdateSQL(obj);
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            setUpdateParameters(statement, obj);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Deletes an entity record from the database based on its ID.
     *
     * @param id The ID of the entity to be deleted from the database.
     */
    @Override
    public void delete(Integer id) {
        String tableName = getTableName();
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Retrieves all entities from the database.
     *
     * @return A list of all entities of type T from the database.
     */
    @Override
    public List<T> getAll() {
        List<T> results = new ArrayList<>();
        String tableName = getTableName();
        String sql = "SELECT * FROM " + tableName;

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                results.add(mapResultSetToObject(resultSet));
            }
        } catch (SQLException | ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return results;
    }
    /**
     * Generates the SQL insert query string for inserting a new entity into the database.
     *
     * @param obj The entity object used to generate the SQL query.
     * @return A string representing the SQL insert query.
     */
    private String generateInsertSQL(T obj) {
        String tableName = getTableName();
        StringBuilder sql = new StringBuilder("INSERT INTO ").append(tableName).append(" (");

        List<String> columns = new ArrayList<>();
        List<String> placeholders = new ArrayList<>();

        Class<?> currentClass = obj.getClass();
        while (currentClass != null) {  // Parcurge ierarhia de clase
            for (var field : currentClass.getDeclaredFields()) {
                if (shouldIncludeField(field)) {
                    field.setAccessible(true);
                    columns.add(toSnakeCase(field.getName()));
                    placeholders.add("?");
                }
            }
            currentClass = currentClass.getSuperclass();  // Mergi la clasa părinte
        }

        if (columns.isEmpty()) {
            throw new IllegalStateException("No fields available for insertion");
        }

        sql.append(String.join(", ", columns));
        sql.append(") VALUES (");
        sql.append(String.join(", ", placeholders));
        sql.append(")");

        System.out.println("Generated SQL: " + sql); // Log the SQL
        return sql.toString();
    }
    /**
     * Sets the parameters of a PreparedStatement for an insert operation.
     *
     * @param preparedStatement The PreparedStatement object to set parameters for.
     * @param entity The entity object containing values to be inserted.
     * @throws SQLException if there is an error setting parameters.
     */
    private void setInsertParameters(PreparedStatement preparedStatement, T entity) throws SQLException {
        int index = 1;
        Class<?> currentClass = entity.getClass();
        try {
            while (currentClass != null) {
                for (var field : currentClass.getDeclaredFields()) {
                    if (shouldIncludeField(field)) {
                        field.setAccessible(true);
                        Object value = field.get(entity);
                        if (value != null && field.getType().isEnum()) {
                            preparedStatement.setObject(index++, value.toString(), Types.VARCHAR);
                        } else {
                            preparedStatement.setObject(index++, value);
                        }
                    }
                }
                currentClass = currentClass.getSuperclass();  // Mergi la clasa părinte
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error accessing field values.", e);
        }
    }
    /**
     * Generates the SQL update query string for updating an existing entity in the database.
     *
     * @param obj The entity object used to generate the SQL update query.
     * @return A string representing the SQL update query.
     */
    private String generateUpdateSQL(T obj) {
        String tableName = getTableName();
        StringBuilder sql = new StringBuilder("UPDATE ").append(tableName).append(" SET ");
        var fields = obj.getClass().getDeclaredFields();
        for (var field : fields) {
            if (shouldIncludeField(field) && !field.getName().equalsIgnoreCase("id")) {
                field.setAccessible(true);
                sql.append(toSnakeCase(field.getName())).append(" = ?, ");
            }
        }
        sql.setLength(sql.length() - 2);
        sql.append(" WHERE id = ?");
        return sql.toString();
    }
    /**
     * Sets the parameters of a PreparedStatement for an update operation.
     *
     * @param statement The PreparedStatement object to set parameters for.
     * @param obj The entity object containing updated values.
     * @throws SQLException if there is an error setting parameters.
     */
    private void setUpdateParameters(PreparedStatement statement, T obj) throws SQLException {
        int index = 1;
        var fields = obj.getClass().getDeclaredFields();
        try {
            for (var field : fields) {
                if (shouldIncludeField(field) && !field.getName().equalsIgnoreCase("id")) {
                    field.setAccessible(true);
                    Object value = field.get(obj);

                    if (value != null && value instanceof Enum) {
                        statement.setObject(index++, value.toString(), Types.VARCHAR);
                    } else if (value == null) {
                        statement.setNull(index++, Types.NULL);
                    } else {
                        statement.setObject(index++, value);
                    }
                }
            }
            statement.setInt(index, obj.getId());
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error accessing field values.", e);
        }
    }
    /**
     * Maps a ResultSet to an object of type T.
     *
     * @param resultSet The ResultSet containing the data to be mapped.
     * @return The entity object populated with data from the ResultSet.
     * @throws SQLException if there is an error processing the ResultSet.
     * @throws ReflectiveOperationException if there is an error reflecting on fields.
     */
    private T mapResultSetToObject(ResultSet resultSet) throws SQLException, ReflectiveOperationException {
        T obj = type.getDeclaredConstructor().newInstance();
        Class<?> currentClass = type;

        while (currentClass != null) {
            var fields = currentClass.getDeclaredFields();
            for (var field : fields) {
                if (shouldIncludeField(field)) {
                    field.setAccessible(true);
                    Object value = resultSet.getObject(toSnakeCase(field.getName()));

                    if (value != null) {
                        if (field.getType().isEnum()) {
                            value = Enum.valueOf((Class<Enum>) field.getType(), value.toString());
                        } else if (field.getType() == java.util.Date.class) {
                            value = new java.util.Date(((Timestamp) value).getTime());
                        } else if (field.getType() == boolean.class || field.getType() == Boolean.class) {
                            value = resultSet.getBoolean(toSnakeCase(field.getName()));
                        }
                    }

                    field.set(obj, value);
                }
            }
            currentClass = currentClass.getSuperclass();
        }
        return obj;
    }
    /**
     * Returns the table name corresponding to the entity type.
     *
     * @return The name of the table associated with the entity type.
     */
    private String getTableName() {
        if (type == Agent.class) {
            return AGENT_TABLE;
        } else if (type == Property.class) {
            return PROPERTY_TABLE;
        } else if (type == Contract.class) {
            return CONTRACT_TABLE;
        } else if (type == Appointment.class) {
            return APPOINTMENT_TABLE;
        } else if (type == Client.class) {
            return CLIENT_TABLE;
        } else if (type == Review.class) {
            return REVIEW_TABLE;
        } else if (type == ClientPreferences.class) {
            return CLIENT_PREFERENCES_TABLE;
        } else {
            throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
    /**
     * Determines if a field should be included in the SQL query.
     *
     * @param field The field to be checked.
     * @return true if the field should be included; false otherwise.
     */
    private boolean shouldIncludeField(Field field) {
        boolean included = !Collection.class.isAssignableFrom(field.getType());
        return included;
    }
    /**
     * Converts a camelCase string to snake_case.
     *
     * @param camelCase The camelCase string to be converted.
     * @return The converted snake_case string.
     */
    private String toSnakeCase(String camelCase) {
        return camelCase.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }
}
