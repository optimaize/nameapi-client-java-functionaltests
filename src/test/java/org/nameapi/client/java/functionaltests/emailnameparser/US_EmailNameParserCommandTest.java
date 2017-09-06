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
public class US_EmailNameParserCommandTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test
    public void test_US_1() throws Exception {
        EmailNameParserCommand command = new EmailNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        EmailNameParserResult result = executor.execute(command, mode, "larry@google.com").get();
        assertEquals(result.getResultType(), EmailAddressParsingResultType.PERSON_NAME);
        assertEquals(result.getBestNameMatch().get().getGivenNames().get(0).getName(), "larry");
    }

    @Test
    public void test_US_2() throws Exception {
        EmailNameParserCommand command = new EmailNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        EmailNameParserResult result = executor.execute(command, mode, "john.doe@example.com").get();
        assertEquals(result.getResultType(), EmailAddressParsingResultType.PERSON_NAME);
        assertEquals(result.getBestNameMatch().get().getGivenNames().get(0).getName(), "john");
        assertEquals(result.getBestNameMatch().get().getSurnames().get(0).getName(), "doe");
    }

    @Test
    public void test_US_3() throws Exception {
        EmailNameParserCommand command = new EmailNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        EmailNameParserResult result = executor.execute(command, mode, "peter.johnson@example.com").get();
        assertEquals(result.getResultType(), EmailAddressParsingResultType.PERSON_NAME);
        assertEquals(result.getBestNameMatch().get().getGivenNames().get(0).getName(), "peter");
        assertEquals(result.getBestNameMatch().get().getSurnames().get(0).getName(), "johnson");
    }

    @Test
    public void test_US_4() throws Exception {
        EmailNameParserCommand command = new EmailNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        EmailNameParserResult result = executor.execute(command, mode, "peterjohnson@example.com").get();
        assertEquals(result.getResultType(), EmailAddressParsingResultType.PERSON_NAME);
        assertEquals(result.getBestNameMatch().get().getGivenNames().get(0).getName(), "peter");
        assertEquals(result.getBestNameMatch().get().getSurnames().get(0).getName(), "johnson");
    }

    @Test
    public void test_US_5() throws Exception {
        EmailNameParserCommand command = new EmailNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        EmailNameParserResult result = executor.execute(command, mode, "johnsonpeter@example.com").get();
        assertEquals(result.getResultType(), EmailAddressParsingResultType.PERSON_NAME);
        assertEquals(result.getBestNameMatch().get().getGivenNames().get(0).getName(), "peter");
        assertEquals(result.getBestNameMatch().get().getSurnames().get(0).getName(), "johnson");
    }

    @Test
    public void test_US_6() throws Exception {
        EmailNameParserCommand command = new EmailNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        EmailNameParserResult result = executor.execute(command, mode, "pjohnson@example.com").get();
        assertEquals(result.getResultType(), EmailAddressParsingResultType.PERSON_NAME);
        assertEquals(result.getBestNameMatch().get().getGivenNames().get(0).getName(), "p");
        assertEquals(result.getBestNameMatch().get().getSurnames().get(0).getName(), "johnson");
    }
}


