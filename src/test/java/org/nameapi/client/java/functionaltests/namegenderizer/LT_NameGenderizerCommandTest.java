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
public class LT_NameGenderizerCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test
    public void test_LT_1() throws Exception {
        PersonGenderizerCommand command = new PersonGenderizerCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NaturalInputPerson person = new NaturalInputPersonBuilder().name(makeName("Jokūbas Paulauskas")).build();
        GenderizerResult genderizerResult = executor.execute(command, mode, person).get();
        assertEquals(genderizerResult.getGender(), ComputedPersonGender.MALE);
    }

    @Test
    public void test_LT_2() throws Exception {
        PersonGenderizerCommand command = new PersonGenderizerCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NaturalInputPerson person = new NaturalInputPersonBuilder().name(makeName("Robertas Antinis Jr.")).build();
        GenderizerResult genderizerResult = executor.execute(command, mode, person).get();
        assertEquals(genderizerResult.getGender(), ComputedPersonGender.MALE);
    }

    @Test
    public void test_LT_3() throws Exception {
        PersonGenderizerCommand command = new PersonGenderizerCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NaturalInputPerson person = new NaturalInputPersonBuilder().name(makeName("Viltė Paulauskienė")).build();
        GenderizerResult genderizerResult = executor.execute(command, mode, person).get();
        assertEquals(genderizerResult.getGender(), ComputedPersonGender.FEMALE);
    }
}
