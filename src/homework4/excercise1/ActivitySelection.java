package homework4.excercise1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ActivitySelection {
    int startTime;
    int endTime;
    public ActivitySelection(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public static List<ActivitySelection> selectActivities(ActivitySelection[] activities) {
        // Sort activities based on finish time
        Arrays.sort(activities, Comparator.comparingInt(a -> a.endTime));

        List<ActivitySelection> selectedActivities = new ArrayList<>();
        selectedActivities.add(activities[0]);
        int lastFinishTime = activities[0].endTime;

        // Iterate through activities
        for (int i = 1; i < activities.length; i++) {
            int startTime = activities[i].startTime;
            int finishTime = activities[i].endTime;
            if (startTime >= lastFinishTime) {
                selectedActivities.add(activities[i]);
                lastFinishTime = finishTime;
            }
        }

        return selectedActivities;
    }
    public static void main(String[] args) {
        ActivitySelection[] activities = {
                new ActivitySelection(1, 3),
                new ActivitySelection(2, 5),
                new ActivitySelection(4, 7),
                new ActivitySelection(1, 8),
                new ActivitySelection(5, 9),
                new ActivitySelection(8, 10),
                new ActivitySelection(9, 11),
                new ActivitySelection(11, 14),
                new ActivitySelection(13, 16),
        };

        List<ActivitySelection> selected = selectActivities(activities);
        System.out.println("Selected activities:");
        for (ActivitySelection activity : selected) {
            System.out.println("Start: " + activity.startTime + " Finish: " + activity.endTime);
        }
    }
}
