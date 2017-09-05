package org.nameapi.client.java.functionaltests.namegenderizer;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.java.functionaltests.AbstractTest;
import org.nameapi.client.java.functionaltests.FunctionalTestsNameApiModeFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.nameapi.client.services.genderizer.persongenderizer.PersonGenderizerCommand;
import org.nameapi.ontology5.input.entities.person.NaturalInputPerson;
import org.nameapi.ontology5.input.entities.person.NaturalInputPersonBuilder;
import org.nameapi.ontology5.input.entities.person.gender.ComputedPersonGender;
import org.nameapi.ontology5.services.genderizer.GenderizerResult;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 */
public class DK_NameGenderizerCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test
    public void test_DK_1() throws Exception {
        PersonGenderizerCommand command = new PersonGenderizerCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NaturalInputPerson person = new NaturalInputPersonBuilder().name(makeName("Aksel Hansen")).build();
        GenderizerResult genderizerResult = executor.execute(command, mode, person).get();
        assertEquals(genderizerResult.getGender(), ComputedPersonGender.MALE);
    }

    @Test
    public void test_DK_2() throws Exception {
        PersonGenderizerCommand command = new PersonGenderizerCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NaturalInputPerson person = new NaturalInputPersonBuilder().name(makeName("Freja Sørensen")).build();
        GenderizerResult genderizerResult = executor.execute(command, mode, person).get();
        assertEquals(genderizerResult.getGender(), ComputedPersonGender.FEMALE);
    }

    @Test
    public void test_DK_3() throws Exception {
        PersonGenderizerCommand command = new PersonGenderizerCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NaturalInputPerson person = new NaturalInputPersonBuilder().name(makeName("Frøken Freja Sørensen")).build();
        GenderizerResult genderizerResult = executor.execute(command, mode, person).get();
        assertEquals(genderizerResult.getGender(), ComputedPersonGender.FEMALE);
    }

    @Test
    public void test_DK_4() throws Exception {
        PersonGenderizerCommand command = new PersonGenderizerCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NaturalInputPerson person = new NaturalInputPersonBuilder().name(makeName("Jørgen Jensen")).build();
        GenderizerResult genderizerResult = executor.execute(command, mode, person).get();
        assertEquals(genderizerResult.getGender(), ComputedPersonGender.MALE);
    }

    @Test
    public void test_DK_5() throws Exception {
        PersonGenderizerCommand command = new PersonGenderizerCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NaturalInputPerson person = new NaturalInputPersonBuilder().name(makeName("Lau Lauritzen, Jr.")).build();
        GenderizerResult genderizerResult = executor.execute(command, mode, person).get();
        assertEquals(genderizerResult.getGender(), ComputedPersonGender.MALE);
    }

    @Test
    public void test_DK_6() throws Exception {
        PersonGenderizerCommand command = new PersonGenderizerCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NaturalInputPerson person = new NaturalInputPersonBuilder().name(makeName("Svend Wiig Hansen")).build();
        GenderizerResult genderizerResult = executor.execute(command, mode, person).get();
        assertEquals(genderizerResult.getGender(), ComputedPersonGender.MALE);
    }
}
