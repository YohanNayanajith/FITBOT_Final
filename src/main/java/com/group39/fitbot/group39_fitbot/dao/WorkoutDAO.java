package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.Workout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkoutDAO {
    public static List<Workout> getWorkout() throws SQLException, ClassNotFoundException {
        List<Workout> workouts = new ArrayList<>();
        Workout workout = new Workout();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM workout";
        PreparedStatement pst = connection.prepareStatement(query);
//        pst.setString(1,register.getFirst_name());

        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if(resultSet != null) {
                workouts.add(new Workout(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10)
                ));
            }
        }
        return workouts;
    }

    public static List<Workout> getVirtualWorkout(int package_id,String workoutType) throws SQLException, ClassNotFoundException {
        List<Workout> virtual_workouts = new ArrayList<>();
        Workout workout = new Workout();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT workout.workout_id,workout.workout_description,workout.total_reps,workout.workout_gender,workout.rest_time,workout.workout_type,workout.duration,workout.exercise,workout.equipment_type,workout.workout_img_url FROM workout\n" +
                "INNER JOIN package_workout ON workout.workout_id=package_workout.workout_id\n" +
                "WHERE package_workout.package_id = ? AND workout.workout_type=?;";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setInt(1,package_id);
        pst.setString(2,workoutType);

        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if(resultSet != null) {
                virtual_workouts.add(new Workout(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10)
                ));
            }
        }
        return virtual_workouts;
    }
}
