package anna.string_operations.service;

import anna.string_operations.OperationContext;
import anna.string_operations.service.operation.IStringOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;

@Service
public class StringHandler {
    private final OperationContext context;
    private final PrintWriter writer;
    private final String separator;
    private final String wrongOperation;
    private final String wrongFormat;


    public StringHandler(OperationContext context,
                         PrintWriter writer,
                         @Value("${separator}") String separator,
                         @Value("${wrongOperation}") String wrongOperation,
                         @Value("${wrongFormat}") String wrongFormat) {
        this.context = context;
        this.writer = writer;
        this.separator = separator;
        this.wrongOperation = wrongOperation;
        this.wrongFormat = wrongFormat;
    }


    @Async("executor")
    public void handleString(String line) throws InterruptedException {
        String res = handleRawString(line);
        writer.println(res);
    }

    String handleRawString(String line) {
        String[] result = line.split(separator);

        if (result.length != 2)
            return line + separator + wrongFormat;

        String stringToPerform = result[0];
        String operationName = result[1];

        IStringOperation stringOperation = context.getOperation(operationName);

        if (stringOperation == null)
            return line + separator + wrongFormat;

        return stringOperation.operate(stringToPerform);

    }
}
