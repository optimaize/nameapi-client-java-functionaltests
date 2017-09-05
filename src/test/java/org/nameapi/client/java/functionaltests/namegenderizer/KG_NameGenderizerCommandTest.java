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
public class KG_NameGenderizerCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test
    public void test_KG_1() throws Exception {
        PersonGenderizerCommand command = new PersonGenderizerCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NaturalInputPerson person = new NaturalInputPersonBuilder().name(makeName("Келдибай Акаевич Аманкожоев")).build();
        GenderizerResult genderizerResult = executor.execute(command, mode, person).get();
        assertEquals(genderizerResult.getGender(), ComputedPersonGender.MALE);
    }

    @Test
    public void test_KG_2() throws Exception {
        PersonGenderizerCommand command = new PersonGenderizerCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NaturalInputPerson person = new NaturalInputPersonBuilder().name(makeName("Marat Zhanybek uulu")).build();
        GenderizerResult genderizerResult = executor.execute(command, mode, person).get();
        assertEquals(genderizerResult.getGender(), ComputedPersonGender.MALE);
    }
}
