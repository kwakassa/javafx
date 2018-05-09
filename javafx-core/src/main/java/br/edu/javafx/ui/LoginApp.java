package br.edu.javafx.ui;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginApp extends Application {

	private AnchorPane pane;
	private TextField txLogin;
	private PasswordField txSenha;
	private Button btEntrar;
	private Button btSair;
	private Scene scene;
	private static Stage stage;

	@Override
	public void start(Stage stage) throws Exception {
		LoginApp.stage = stage;
		// initComponents()
		initComponents();
		// initLayout
		initLayout();
		// initListeners
		initListeners();
		// Show
		stage.show();
	}

	private void initComponents() {
		pane = new AnchorPane();
		pane.setPrefSize(400, 300);
		/* Nosso primeiro toque de requinte... */
		pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, blue 0%, silver 100%);");

		scene = new Scene(pane);

		// Add Stage to scene
		stage.setScene(scene);

		txLogin = new TextField();
		txLogin.setPromptText("Digite aqui seu login");

		txSenha = new PasswordField();
		txSenha.setPromptText("Digite aqui sua senha");
		btEntrar = new Button("Entrar");
		btSair = new Button("Sair");

		// Add Components to pane
		pane.getChildren().addAll(txLogin, txSenha, btEntrar, btSair);
	}

	private void initLayout() {
		// Ajuste de Posicoes dos Componentes
		txLogin.setLayoutX((pane.getWidth() - txLogin.getWidth()) / 2);
		txLogin.setLayoutY(50);
		txSenha.setLayoutX((pane.getWidth() - txSenha.getWidth()) / 2);
		txSenha.setLayoutY(100);
		btEntrar.setLayoutX((pane.getWidth() - btEntrar.getWidth()) / 2);
		btEntrar.setLayoutY(150);
		btSair.setLayoutX((pane.getWidth() - btSair.getWidth()) / 2);
		btSair.setLayoutY(200);

	}

	private void initListeners() {
		btEntrar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				logar();
			}
		});
		btSair.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				fecharAplicacao();
			}
		});
	}

	private void logar() {
		if (txLogin.getText().equals("admin") && txSenha.getText().equals("casadocodigo")) {
			// TODO Abrir a tela VitrineApp
		} else {
			JOptionPane.showMessageDialog(null, "Login e/ou senha inválidos", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void fecharAplicacao() {
		System.exit(0);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
