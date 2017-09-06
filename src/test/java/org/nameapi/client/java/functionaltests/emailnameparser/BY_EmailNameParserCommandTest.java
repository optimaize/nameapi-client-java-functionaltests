package org.nameapi.client.java.functionaltests.emailnameparser;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.java.functionaltests.FunctionalTestsNameApiModeFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.nameapi.client.services.email.emailnameparser.EmailNameParserCommand;
import org.nameapi.ontology5.services.email.emailnameparser.EmailAddressParsingResultType;
import org.nameapi.ontology5.services.email.emailnameparser.EmailNameParserResult;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 */
public class BY_EmailNameParserCommandTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test
    public void test_BY_1() throws Exception {
        EmailNameParserCommand command = new EmailNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        EmailNameParserResult result = executor.execute(command, mode, "nikita.ivanou@example.by").get();
        assertEquals(result.getResultType(), EmailAddressParsingResultType.PERSON_NAME);
        assertEquals(result.getBestNameMatch().get().getGivenNames().get(0).getName(), "nikita");
        assertEquals(result.getBestNameMatch().get().getSurnames().get(0).getName(), "ivanou");
    }

    @Test
    public void test_BY_2() throws Exception {
        EmailNameParserCommand command = new EmailNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        EmailNameParserResult result = executor.execute(command, mode, "nikita.ivanou@example.by").get();
        assertEquals(result.getResultType(), EmailAddressParsingResultType.PERSON_NAME);
        assertEquals(result.getBestNameMatch().get().getGivenNames().get(0).getName(), "nikita");
        assertEquals(result.getBestNameMatch().get().getSurnames().get(0).getName(), "ivanou");
    }
}


