package anna.string_operations.confg;

import anna.string_operations.LineReader;
import anna.string_operations.OperationContext;
import anna.string_operations.service.StringHandler;
import anna.string_operations.service.operation.IStringOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;


@Configuration
public class AppConfiguration {

    private final String outFilename;
    private final String inFilename;

    public AppConfiguration(
            @Value("${anna.string_operations.output.file.path}") String outFilename,
            @Value("${anna.string_operations.input.file.path}") String inFilename
    ) {
        this.outFilename = outFilename;
        this.inFilename = inFilename;
    }

    @Bean
    public PrintWriter writer() throws FileNotFoundException {
        return new PrintWriter(new FileOutputStream(outFilename));
    }

    @Bean
    public OperationContext context(List<IStringOperation> operations) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return new OperationContext(operations);
    }

    @Bean
    public LineReader lineReader(StringHandler handler) {
        return new LineReader(inFilename, handler);
    }
}
