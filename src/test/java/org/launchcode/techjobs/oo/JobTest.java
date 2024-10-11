package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId(){
        Job jobOne = new Job();
        Job jobTwo = new Job();
        assertNotEquals(jobTwo,jobOne);

    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job jobTest = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(jobTest.getName(),"Product tester");
        assertEquals(jobTest.getEmployer().getValue(),"ACME");
        assertEquals(jobTest.getLocation().getValue(),"Desert");
        assertTrue(jobTest.getPositionType().getValue().equals( "Quality control"));
        assertTrue(jobTest.getCoreCompetency().getValue().equals( "Persistence"));
    }

    @Test
    public void testJobsForEquality(){
        Job jobOne =  new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobTwo =  new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(jobOne.getName(),jobTwo.getName());
        assertEquals(jobOne.getEmployer().getValue(),jobTwo.getEmployer().getValue());
        assertEquals(jobOne.getLocation().getValue(),jobTwo.getLocation().getValue());
        assertEquals(jobOne.getPositionType().getValue(),jobTwo.getPositionType().getValue());
        assertEquals(jobOne.getCoreCompetency().getValue(),jobTwo.getCoreCompetency().getValue() );
        assertNotEquals(jobOne.getId(), jobTwo.getId());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job jobTest =  new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String lineSeparator = System.lineSeparator();
        String test = jobTest.toString();
        assertTrue(test.startsWith(lineSeparator));
        assertTrue(test.endsWith(lineSeparator));


    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job jobFour =  new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String lineSeparator = System.lineSeparator();
        String compareString = lineSeparator+"ID: "+ jobFour.getId()+lineSeparator+"Name: Product tester"+ lineSeparator
                + "Employer: ACME" + lineSeparator+ "Location: Desert"+ lineSeparator+ "Position Type: Quality control"
                + lineSeparator+ "Core Competency: Persistence" +lineSeparator;

        assertEquals(jobFour.toString(), compareString);

    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job jobFive = new Job();
        String lineSeparator = System.lineSeparator();
        String compareString = lineSeparator+"ID: "+jobFive.getId()+lineSeparator+"Name: Data not available"+ lineSeparator + "Employer: Data not available"
                + lineSeparator+ "Location: Data not available"+ lineSeparator+ "Position Type: Data not available"+ lineSeparator+
                "Core Competency: Data not available" +lineSeparator;
        assertEquals(jobFive.toString(), compareString);

    }

}
