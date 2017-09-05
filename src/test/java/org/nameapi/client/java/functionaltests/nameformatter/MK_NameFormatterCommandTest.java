package org.nameapi.client.java.functionaltests.nameformatter;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.java.functionaltests.AbstractTest;
import org.nameapi.client.java.functionaltests.FunctionalTestsNameApiModeFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.nameapi.client.services.formatter.personnameformatter.PersonNameFormatterArgument;
import org.nameapi.client.services.formatter.personnameformatter.PersonNameFormatterCommand;
import org.nameapi.ontology5.input.entities.person.NaturalInputPerson;
import org.nameapi.ontology5.input.entities.person.NaturalInputPersonBuilder;
import org.nameapi.ontology5.services.formatter.FormatterProperties;
import org.nameapi.ontology5.services.formatter.FormatterResult;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 */
public class MK_NameFormatterCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test
    public void test_MK_1() throws Exception {
        PersonNameFormatterCommand command = new PersonNameFormatterCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();

        NaturalInputPerson person = new NaturalInputPersonBuilder().name(makeName("DIMO TODOROVSKI")).build();
        FormatterProperties properties = new FormatterProperties(true);
        PersonNameFormatterArgument argument = new PersonNameFormatterArgument(person, properties);
        FormatterResult formatterResult = executor.execute(command, mode, argument).get();
        assertEquals(formatterResult.getFormatted(), "Dimo Todorovski");
    }

    @Test
    public void test_MK_2() throws Exception {
        PersonNameFormatterCommand command = new PersonNameFormatterCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();

        NaturalInputPerson person = new NaturalInputPersonBuilder().name(makeName("дИмО ТоДоРоВсКи")).build();
        FormatterProperties properties = new FormatterProperties(true);
        PersonNameFormatterArgument argument = new PersonNameFormatterArgument(person, properties);
        FormatterResult formatterResult = executor.execute(command, mode, argument).get();
        assertEquals(formatterResult.getFormatted(), "Димо Тодоровски");
    }
}
