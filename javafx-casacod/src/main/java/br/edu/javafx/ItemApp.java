package br.edu.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ItemApp extends Application {

	private AnchorPane pane;
	private ImageView imgItem;
	private Label lbPreco, lbDescricao;
	private Button btAddCarrinho;
	private static Stage stage;
	private static Produto produto;
	private static int index;
	private static String[] images = { "http://www.sportcenterlopes.com.br/images/" + "250_topper_campo_2009replic.jpg",
			"http://1.bp.blogspot.com/_H8uGs8K8kaY/TLZTXR8nIgI/" + "AAAAAAAAF_0/BvpxdqGF4PE/s1600/luva_umbro.png",
			"http://bimg2.mlstatic.com/camisa-nike-active-importada-manga-"
					+ "longa-esportiva-vermelha_MLB-F-199843960_1391.jpg",
			"http://www.showtenis.com.br/images/_product/979/979112/"
					+ "chuteira-nike-mercurial-glide-3-fg-campo--199fd9.jpg",
			"http://www.katy.com.br/imagens/produtos/original/"
					+ "caneleira-topper-trainning-difusion-13340619502673137.jpg" };

	public static Produto getProduto() {
		return produto;
	}

	public static void setProduto(Produto produto) {
		ItemApp.produto = produto;
	}

	private void initComponents() {
		pane = new AnchorPane();
		pane.setPrefSize(600, 400);
		lbDescricao = new Label("Descricao");
		lbPreco = new Label("Preco");
		btAddCarrinho = new Button("Add Carrinho");
		imgItem = new ImageView(new Image(images[index]));
		pane.getChildren().addAll(lbDescricao, lbPreco, btAddCarrinho);
	}

	private void initLayout() {
		lbDescricao.setLayoutX((pane.getWidth() - lbDescricao.getWidth()) / 2);
		lbDescricao.setLayoutY(50);
		lbPreco.setLayoutX((pane.getWidth() - lbPreco.getWidth()) / 2);
		lbPreco.setLayoutY(100);
		btAddCarrinho.setLayoutX((pane.getWidth() - btAddCarrinho.getWidth()) / 2);
		btAddCarrinho.setLayoutY(150);

	}

	private void initListeners() {
		btAddCarrinho.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

			}
		});
	}

	@Override
	public void start(Stage stage) throws Exception {
		initComponents();
		initListeners();
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		// Remove a opção de maximizar a tela
		stage.setResizable(false);
		// Dá um título para a tela
		stage.setTitle("Itens - GolFX");
		stage.show();
		initLayout();
		ItemApp.stage = stage;
	}

	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		ItemApp.index = index;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
