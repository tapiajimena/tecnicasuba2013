package fiuba.tecnicas.presentacion;

import fiuba.tecnicas.presentacion.DomainPresenter.IConsoleView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ConsoleView implements IConsoleView{
	private DomainPresenter presenter;
	private String command;
	private String parametros;
	
	public ConsoleView() {
		presenter = new DomainPresenter(this);
	}

	@Override
	public DomainPresenter getPresenter() {		
		return this.presenter;
	}
	
	@Override
	public String getInput() {
		String aux = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("--> ");
        try {
			aux = br.readLine();
		} catch (IOException e) {
			aux= "commandDefault";
			e.printStackTrace();
		}
        return aux;
	}

	private String[] splitInput(String input) {
		String[] parametros = {"",""};
		if (!input.isEmpty()) {
			parametros=input.split("/");
		}
		return parametros;
	}
	
	@Override
	public String getCommandFromInput(String input) {
		String[] aux = splitInput(input);
		return aux.length > 0? aux[0] : "";
	}
	
	@Override
	public String getParametersFromInput(String input) {
		String[] aux = splitInput(input);
		return aux.length > 1? aux[1] : "";
	}
	
	@Override
	public void run() {
		System.out.println(presenter.getMensajeBienvenida());
		String input = getInput();
		while (!input.equals("Salir")) {
			System.out.print(presenter.getCommand(getCommandFromInput(input)).execute(getParametersFromInput(input)).getMensaje());
			input = getInput();
		}
	}
}
