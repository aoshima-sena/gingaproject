package stack;

import java.util.ArrayList;
import java.util.List;

public class StackAnswer {

	/*
	 *データ構造の一つにスタックがあります。スタックとは以下の条件を満たすデータ構造です。
	 *
	 *追加された要素は最後尾に追加される (push)
	 *取り出される要素は最後が取り出される(pop)
	 *
	 *このデータ構造を満たすようpop、pushメソッドを実装してStackを完成させ実行結果と同じ実行結果になるように実装してください。
	 *
	 *-----実行結果-----
	 *==> 3, 1, 4
	 *==> 3, 1
	 *==> 3, 1, 2
	 *==> 3, 1
	 *==> 3
	 *==>
	 */

	private List<Integer> stack;

	public static void main(String[] args) {
		StackAnswer stack = new StackAnswer();
		stack.push(3);
		stack.push(1);
		stack.push(4);
		stack.print();
		stack.pop();
		stack.print();
		stack.push(2);
		stack.print();
		stack.pop();
		stack.print();
		stack.pop();
		stack.print();
		stack.pop();
		stack.print();
	}

	public StackAnswer() {
		this.stack = new ArrayList<Integer>();
	}

	public Integer pop() {
		Integer value = this.stack.get(this.stack.size() - 1);//最後の要素を取り出す
		this.stack.remove(this.stack.lastIndexOf(value));//取り出した要素をリストから削除
		return value;
	}

	public void push(Integer value) {
		this.stack.add(value);//後ろに追加する
	}

	public void print() {
		//正規表現 [, ] は\\でエスケープ処理 |で複数指定
		System.out.println("==> " + this.stack.toString().replaceAll("\\[|\\]", ""));
	}

}
