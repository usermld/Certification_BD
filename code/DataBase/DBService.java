package DataBase;

import com.example.Animals.AnimalDto;
import java.sql.*;
import java.util.ArrayList;

import static DataBase.Db.connect;

public class DBService {
    private Connection connect;

    public void creatTable() throws SQLException, ClassNotFoundException {
        String CREATE_TABLE =
                "CREATE TABLE " + Db.TABLE
                        + " (animal_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                        + "animal_name TEXT NOT NULL,"
                        + "animal_type TEXT NOT NULL,"
                        + "commands TEXT,"
                        + "date_of_birth DATE);";
        this.connect = connect();
        try (Connection connection = this.connect) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(CREATE_TABLE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertAnimal(AnimalDto animalDto) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO " + Db.TABLE + " (animal_name, animal_type, commands, date_of_birth) " +
                "VALUES (?,?,?,?);";
        this.connect = connect();
        try (Connection connection = this.connect;
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, animalDto.getName());
            pstmt.setString(2, String.valueOf(animalDto.getType()));
            pstmt.setString(3, animalDto.getCommands().toString());
            pstmt.setDate(4, animalDto.getDate_of_birth());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public AnimalDto getAnimal(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM " + Db.TABLE +" WHERE animal_id = ?";
        this.connect = connect();
        try (Connection connection = this.connect;
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet resultSet = pstmt.executeQuery();
            AnimalDto animal = null;
            while (resultSet.next()){
                animal = new AnimalDto(resultSet.getInt("animal_id"),
                        resultSet.getString("animal_name"),
                        resultSet.getString("animal_type"),
                        resultSet.getString("commands"),
                        resultSet.getString("date_of_birth"));

            }
            return animal;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ArrayList getAllAnimals() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM " + Db.TABLE;
        this.connect = connect();
        try (Connection connection = this.connect;
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet resultSet = pstmt.executeQuery();
            AnimalDto animal = null;
            ArrayList result = new ArrayList<>();
            while (resultSet.next()){
                animal = new AnimalDto(resultSet.getInt("animal_id"),
                        resultSet.getString("animal_name"),
                        resultSet.getString("animal_type"),
                        resultSet.getString("commands"),
                        resultSet.getString("date_of_birth"));
                result.add(animal);
            }
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void newCommand(int id, String command) throws SQLException, ClassNotFoundException {
        AnimalDto animal = getAnimal(id);
        animal.setCommands(command);
        String sql = "UPDATE " + Db.TABLE + " SET commands = ? WHERE animal_id = ?";
        this.connect = connect();
        try (Connection connection = this.connect;
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, animal.getCommands().toString());
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delAnimal(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM " + Db.TABLE + " WHERE animal_id = ?";
        this.connect = connect();
        try (Connection connection = this.connect;
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}