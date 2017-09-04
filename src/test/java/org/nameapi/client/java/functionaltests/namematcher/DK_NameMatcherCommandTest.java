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
public class DK_NameMatcherCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test
    public void test_DK_1() throws Exception {
        PersonMatcherCommand command = new PersonMatcherCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NaturalInputPerson person1 = new NaturalInputPersonBuilder().name(makeName("Freja Sørensen")).build();
        NaturalInputPerson person2 = new NaturalInputPersonBuilder().name(makeName("Frk. F. Sørensen")).build();
        PersonMatcherArgument argument = new PersonMatcherArgument(person1, person2);
        PersonMatcherResult result = executor.execute(command, mode, argument).get();
        assertEquals(result.getMatchType(), PersonMatchType.MATCHING);
    }

    @Test
    public void test_DK_2() throws Exception {
        PersonMatcherCommand command = new PersonMatcherCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NaturalInputPerson person1 = new NaturalInputPersonBuilder().name(makeName("Jørgen Jensen")).build();
        NaturalInputPerson person2 = new NaturalInputPersonBuilder().name(makeName("Jørn Jensen")).build();
        PersonMatcherArgument argument = new PersonMatcherArgument(person1, person2);
        PersonMatcherResult result = executor.execute(command, mode, argument).get();
        assertEquals(result.getMatchType(), PersonMatchType.MATCHING);
    }

    @Test
    public void test_DK_3() throws Exception {
        PersonMatcherCommand command = new PersonMatcherCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NaturalInputPerson person1 = new NaturalInputPersonBuilder().name(makeName("Jørgen Jensen")).build();
        NaturalInputPerson person2 = new NaturalInputPersonBuilder().name(makeName("J. Jensen")).build();
        PersonMatcherArgument argument = new PersonMatcherArgument(person1, person2);
        PersonMatcherResult result = executor.execute(command, mode, argument).get();
        assertEquals(result.getMatchType(), PersonMatchType.MATCHING);
    }

    @Test
    public void test_DK_4() throws Exception {
        PersonMatcherCommand command = new PersonMatcherCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NaturalInputPerson person1 = new NaturalInputPersonBuilder().name(makeName("Lau Lauritzen, Jr.")).build();
        NaturalInputPerson person2 = new NaturalInputPersonBuilder().name(makeName("L. Lauritzen")).build();
        PersonMatcherArgument argument = new PersonMatcherArgument(person1, person2);
        PersonMatcherResult result = executor.execute(command, mode, argument).get();
        assertEquals(result.getMatchType(), PersonMatchType.MATCHING);
    }

    @Test
    public void test_DK_5() throws Exception {
        PersonMatcherCommand command = new PersonMatcherCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NaturalInputPerson person1 = new NaturalInputPersonBuilder().name(makeName("Svend Wiig Hansen")).build();
        NaturalInputPerson person2 = new NaturalInputPersonBuilder().name(makeName("S. Hansen")).build();
        PersonMatcherArgument argument = new PersonMatcherArgument(person1, person2);
        PersonMatcherResult result = executor.execute(command, mode, argument).get();
        assertEquals(result.getMatchType(), PersonMatchType.MATCHING);
    }
}
