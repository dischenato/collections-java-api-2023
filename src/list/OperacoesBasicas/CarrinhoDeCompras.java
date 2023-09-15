package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
  
  private List<Item> itemList;

  public CarrinhoDeCompras() {
    this.itemList = new ArrayList<>();
  }

  public void adicionarItem(String nome, double preco, int quantidade) {
    Item item = new Item(nome, preco, quantidade);
    this.itemList.add(item);
  }

  public void removerItem(String nome) {
    List<Item> itensParaRemover = new ArrayList<>();
    if (!itemList.isEmpty()) {
      for (Item i : itemList) {
        if (i.getNome().equalsIgnoreCase(nome)) {
          itensParaRemover.add(i);
        }
      }
      itemList.removeAll(itensParaRemover);
    } else {
      System.out.println("Lista Vazia!");
    }
  }

  public double calcularValorTotal() {
    double valorTotal = 0d;
    if (!itemList.isEmpty()) {
      for (Item item : itemList) {
        double valorItem = item.getPreco() * item.getQuant();
        valorTotal += valorItem;
      }
      return valorTotal;
    } else {
      throw new RuntimeException("Lista Vazia!");
    }
  }

  public void exibirItens() {
    if (!itemList.isEmpty()) {
      System.out.println(this.itemList);
    } else {
      System.out.println("Lista Vazia!");
    }
  }

  @Override
public String toString() {
    return "CarrinhoDeCompras [itemList=" + itemList + "]";
}

public static void main(String[] args) {

    CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

    carrinhoDeCompras.adicionarItem("Lápis", 2d, 3);
    carrinhoDeCompras.adicionarItem("Lápis", 2d, 3);
    carrinhoDeCompras.adicionarItem("Caderno", 35d, 1);
    carrinhoDeCompras.adicionarItem("Borracha", 2d, 2);

    carrinhoDeCompras.exibirItens();

    carrinhoDeCompras.removerItem("Lápis");

    carrinhoDeCompras.exibirItens();

    System.out.println("Total da compra = " + carrinhoDeCompras.calcularValorTotal());
  }
}