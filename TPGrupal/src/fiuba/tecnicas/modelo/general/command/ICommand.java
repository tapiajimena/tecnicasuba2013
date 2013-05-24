package fiuba.tecnicas.modelo.general.command;

import fiuba.tecnicas.modelo.comun.Resultado;

public interface ICommand {
  public Resultado execute(String input);
}
