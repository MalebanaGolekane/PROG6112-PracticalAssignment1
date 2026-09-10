package prog6112;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tekano Malebana
 */
public class Series {

    private ArrayList<SeriesModel> seriesList = new ArrayList<>();

    public void CaptureSeries() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("CAPTURE A NEW SERIES");
        System.out.print("Enter the series id: ");
        String id = scanner.nextLine();
        System.out.print("Enter the series name: ");
        String name = scanner.nextLine();
        String age;
        while (true) {
            System.out.print("Enter the series age restriction: ");
            age = scanner.nextLine();
            if (isValidAge(age)) {
                break;
            } else {
                System.out.println("You have entered an incorrect series age!!");
                System.out.println("Please re-enter the series age >>");
            }
        }
        System.out.print("Enter the number of episodes for " + name + ": ");
        String episodes = scanner.nextLine();
        SeriesModel series = new SeriesModel();
        series.Seriesid = id;
        series.SeriesName = name;
        series.SeriesAge = age;
        series.SeriesNumberOfEpisodes = episodes;
        seriesList.add(series);
        System.out.println("Series processed successfully !!!");
    }

    public void SearchSeries() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter the series id to search: ");
        String searchId = scanner.nextLine();
        SeriesModel series = findSeries(searchId);
        if (series != null) {
            System.out.println("SERIES ID: " + series.Seriesid);
            System.out.println("SERIES NAME: " + series.SeriesName);
            System.out.println("SERIES AGE RESTRICTION: " + series.SeriesAge);
            System.out.println("SERIES NUMBER OF EPISODES: " + series.SeriesNumberOfEpisodes);
        } else {
            System.out.println("Series with Series Id: " + searchId + " was not Found!");
        }
    }

    public void UpdateSeries() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter the series id to update: ");
        String updateId = scanner.nextLine();
        SeriesModel series = findSeries(updateId);
        if (series != null) {
            System.out.print("Enter the series name: ");
            String name = scanner.nextLine();
            String age;
            while (true) {
                System.out.print("Enter the age restriction: ");
                age = scanner.nextLine();
                if (isValidAge(age)) {
                    break;
                } else {
                    System.out.println("You have entered an incorrect series age!!");
                    System.out.println("Please re-enter the series age >>");
                }
            }
            System.out.print("Enter the number of episodes: ");
            String episodes = scanner.nextLine();
            series.SeriesName = name;
            series.SeriesAge = age;
            series.SeriesNumberOfEpisodes = episodes;
            System.out.println("Series updated successfully!");
        } else {
            System.out.println("Series with Series Id: " + updateId + " was not Found!");
        }
    }

    public boolean updateSeries(String id, String name, String age, String episodes) {
        if (!isValidAge(age)) {
            return false;
        }
        SeriesModel series = findSeries(id);
        if (series == null) {
            return false;
        }
        series.SeriesName = name;
        series.SeriesAge = age;
        series.SeriesNumberOfEpisodes = episodes;
        return true;
    }

    public void DeleteSeries() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter the series id to delete: ");
        String deleteId = scanner.nextLine();
        SeriesModel series = findSeries(deleteId);
        if (series != null) {
            System.out.println("Are you sure you want to delete series " + deleteId + " from the system? Yes (y) to delete.");
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("y")) {
                seriesList.remove(series);
                System.out.println("Series with Series Id: " + deleteId + " WAS deleted!");
            } else {
                System.out.println("Series was not deleted.");
            }
        } else {
            System.out.println("Series with Series Id: " + deleteId + " was not Found!");
        }
    }

    public boolean deleteSeries(String id) {
        SeriesModel series = findSeries(id);
        if (series == null) {
            return false;
        }
        seriesList.remove(series);
        return true;
    }

    public void SeriesReport() {
        System.out.println();
        if (seriesList.isEmpty()) {
            System.out.println("No series have been captured yet.");
            return;
        }
        for (int i = 0; i < seriesList.size(); i++) {
            SeriesModel series = seriesList.get(i);
            System.out.println("Series " + (i + 1));
            System.out.println("SERIES ID: " + series.Seriesid);
            System.out.println("SERIES NAME: " + series.SeriesName);
            System.out.println("SERIES AGE RESTRICTION: " + series.SeriesAge);
            System.out.println("NUMBER OF EPISODES: " + series.SeriesNumberOfEpisodes);
            System.out.println();
        }
    }

    public void ExitSeriesApplication() {
        System.out.println();
        System.out.println("Thank you for using the Series Application.");
        System.out.println("Goodbye!");
    }

    public void Menu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 6) {
            System.out.println();
            System.out.println("Please select one of the following menu items:");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Update series age restriction.");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application.");
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid option. Please enter a number from 1 to 6.");
                continue;
            }
            switch (choice) {
                case 1: CaptureSeries(); break;
                case 2: SearchSeries(); break;
                case 3: UpdateSeries(); break;
                case 4: DeleteSeries(); break;
                case 5: SeriesReport(); break;
                case 6: ExitSeriesApplication(); break;
                default: System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void addSeries(SeriesModel series) {
        seriesList.add(series);
    }

    public SeriesModel findSeries(String id) {
        for (SeriesModel series : seriesList) {
            if (series.Seriesid.equals(id)) {
                return series;
            }
        }
        return null;
    }

    public boolean isValidAge(String age) {
        try {
            int ageNumber = Integer.parseInt(age);
            return ageNumber >= 2 && ageNumber <= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
