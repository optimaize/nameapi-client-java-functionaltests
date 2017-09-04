package org.nameapi.client.java.functionaltests.namematcher;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.java.functionaltests.AbstractTest;
import org.nameapi.client.java.functionaltests.FunctionalTestsNameApiModeFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.nameapi.client.services.matcher.personmatcher.PersonMatcherArgument;
import org.nameapi.client.services.matcher.personmatcher.PersonMatcherCommand;
import org.nameapi.ontology5.input.entities.person.NaturalInputPerson;
import org.nameapi.ontology5.input.entities.person.NaturalInputPersonBuilder;
import org.nameapi.ontology5.services.matcher.personmatcher.PersonMatchType;
import org.nameapi.ontology5.services.matcher.personmatcher.PersonMatcherResult;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 */
public class LT_NameMatcherCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test
    public void test_LT_1() throws Exception {
        PersonMatcherCommand command = new PersonMatcherCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NaturalInputPerson person1 = new NaturalInputPersonBuilder().name(makeName("Jokūbas Paulauskas")).build();
        NaturalInputPerson person2 = new NaturalInputPersonBuilder().name(makeName("J. Paulauskas")).build();
        PersonMatcherArgument argument = new PersonMatcherArgument(person1, person2);
        PersonMatcherResult result = executor.execute(command, mode, argument).get();
        assertEquals(result.getMatchType(), PersonMatchType.MATCHING);
    }

    @Test
    public void test_LT_2() throws Exception {
        PersonMatcherCommand command = new PersonMatcherCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NaturalInputPerson person1 = new NaturalInputPersonBuilder().name(makeName("Robertas Antinis Jr.")).build();
        NaturalInputPerson person2 = new NaturalInputPersonBuilder().name(makeName("R. Antinis")).build();
        PersonMatcherArgument argument = new PersonMatcherArgument(person1, person2);
        PersonMatcherResult result = executor.execute(command, mode, argument).get();
        assertEquals(result.getMatchType(), PersonMatchType.MATCHING);
    }
}
