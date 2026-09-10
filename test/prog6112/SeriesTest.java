package prog6112;

import org.junit.Test;
import static org.junit.Assert.*;

public class SeriesTest {

    @Test
    public void TestSearchSeries() {
        Series series = new Series();
        SeriesModel testSeries = new SeriesModel();
        testSeries.Seriesid = "S001";
        testSeries.SeriesName = "Stranger Things";
        testSeries.SeriesAge = "16";
        testSeries.SeriesNumberOfEpisodes = "8";
        series.addSeries(testSeries);
        SeriesModel result = series.findSeries("S001");
        assertNotNull(result);
        assertEquals("Stranger Things", result.SeriesName);
    }

    @Test
    public void TestSearchSeries_SeriesNotFound() {
        Series series = new Series();
        SeriesModel testSeries = new SeriesModel();
        testSeries.Seriesid = "S001";
        testSeries.SeriesName = "Stranger Things";
        testSeries.SeriesAge = "16";
        testSeries.SeriesNumberOfEpisodes = "8";
        series.addSeries(testSeries);
        SeriesModel result = series.findSeries("S999");
        assertNull(result);
    }

    @Test
    public void TestUpdateSeries() {
        Series series = new Series();
        SeriesModel testSeries = new SeriesModel();
        testSeries.Seriesid = "S001";
        testSeries.SeriesName = "Stranger Things";
        testSeries.SeriesAge = "16";
        testSeries.SeriesNumberOfEpisodes = "8";
        series.addSeries(testSeries);
        boolean updated = series.updateSeries("S001", "Stranger Things Season 5", "16", "10");
        assertTrue(updated);
        SeriesModel result = series.findSeries("S001");
        assertNotNull(result);
        assertEquals("Stranger Things Season 5", result.SeriesName);
        assertEquals("16", result.SeriesAge);
        assertEquals("10", result.SeriesNumberOfEpisodes);
    }

    @Test
    public void TestDeleteSeries() {
        Series series = new Series();
        SeriesModel testSeries = new SeriesModel();
        testSeries.Seriesid = "S001";
        testSeries.SeriesName = "Stranger Things";
        testSeries.SeriesAge = "16";
        testSeries.SeriesNumberOfEpisodes = "8";
        series.addSeries(testSeries);
        boolean deleted = series.deleteSeries("S001");
        assertTrue(deleted);
        SeriesModel result = series.findSeries("S001");
        assertNull(result);
    }

    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        Series series = new Series();
        SeriesModel testSeries = new SeriesModel();
        testSeries.Seriesid = "S001";
        testSeries.SeriesName = "Stranger Things";
        testSeries.SeriesAge = "16";
        testSeries.SeriesNumberOfEpisodes = "8";
        series.addSeries(testSeries);
        boolean deleted = series.deleteSeries("S999");
        assertFalse(deleted);
        SeriesModel result = series.findSeries("S001");
        assertNotNull(result);
    }

    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        Series series = new Series();
        assertTrue(series.isValidAge("2"));
        assertTrue(series.isValidAge("10"));
        assertTrue(series.isValidAge("18"));
    }

    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInValid() {
        Series series = new Series();
        assertFalse(series.isValidAge("1"));
        assertFalse(series.isValidAge("19"));
        assertFalse(series.isValidAge("25"));
        assertFalse(series.isValidAge("abc"));
    }
}
