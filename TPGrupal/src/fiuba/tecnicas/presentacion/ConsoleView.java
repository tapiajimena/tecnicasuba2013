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
	public String getCommandFromInput() {
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
	

	@Override
	public void run() {
		System.out.println(presenter.getMensajeBienvenida());
		System.out.print(presenter.getCommand(getCommandFromInput()).execute("").getMensaje());
	}

}
