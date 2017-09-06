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
public class VN_EmailNameParserCommandTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test
    public void test_VN_1() throws Exception {
        EmailNameParserCommand command = new EmailNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        EmailNameParserResult result = executor.execute(command, mode, "nguyen.quangdung@example.vn").get();
        assertEquals(result.getResultType(), EmailAddressParsingResultType.PERSON_NAME);
        assertEquals(result.getBestNameMatch().get().getGivenNames().get(0).getName(), "quangdung");
        assertEquals(result.getBestNameMatch().get().getSurnames().get(0).getName(), "nguyen");
    }
}


