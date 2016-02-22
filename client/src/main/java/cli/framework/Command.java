package cli.framework;

import java.util.List;

public abstract class Command<T> {

	abstract public String identifier();
	abstract public void execute();
	abstract public String describe();

	public boolean shouldContinue() { return true; }  // default implementation
	public void load(List<String> args) {  }          // default implementation


	protected T system;

	public void withSystem(T system)                    { this.system = system;   }

	public boolean process(List<String> args) {
		try { load(args); }
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
		execute();
		return shouldContinue();
	}

}