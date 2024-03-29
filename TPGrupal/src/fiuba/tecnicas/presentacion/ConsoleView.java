package fiuba.tecnicas.presentacion;

import fiuba.tecnicas.presentacion.DomainPresenter.IConsoleView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleView implements IConsoleView{
	private DomainPresenter presenter;
	
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
		return aux.length > 0? aux[0].trim() : "";
	}
	
	@Override
	public String getParametersFromInput(String input) {
		String[] aux = splitInput(input);
		return aux.length > 1? aux[1].trim() : "";
	}
	
	@Override
	public void run() {
		System.out.println(presenter.getMensajeBienvenida());
		String input = getInput();
		while (!presenter.quitAplicacion(input)) {
			System.out.println(presenter.executeCommand(input).getMensaje());
			input = getInput();
		}
	}
}
