package anna.string_operations;

import anna.string_operations.service.operation.IStringOperation;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;


@Component
public class OperationContext {
    private Map<String, IStringOperation> operationByName;


    public OperationContext(List<IStringOperation> operations) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        operationByName = operations.stream()
                .collect(toMap(IStringOperation::getName, operation -> operation));

    }

    public IStringOperation getOperation(String name) {
        return operationByName.get(name);
    }
}
