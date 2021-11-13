package Domain.Services;

/**
 * @author roed
 */
public class ExceptionService extends Throwable {
  public ExceptionService(String message) {
    super(message);
  }
}
