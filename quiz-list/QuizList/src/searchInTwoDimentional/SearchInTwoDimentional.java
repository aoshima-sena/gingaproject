package searchInTwoDimentional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchInTwoDimentional {

	/*
	 * 以下は定義されている二次元リストの行における最大値、列における最大値、対角における最大値をそれぞれ求め表示するプログラムの作成途中となるものです。
	 * コードを追記して完成させてください。
	 *
	 * ただし、追記する所は
	 * //ここから
	 * //ここまで
	 * の所にすること。
	 * 行の最大値はmaxNumberOfRowListに、列の最大値はmaxNumberOfColumnList、対角の最大値はmaxNumberOfDiagonalListに追加すること。
	 * 追加された最大値のインデックスとその行、または列のインデックスが一致すること。
	 * （0行目の最大値はmaxNumberOfRowListの0番目に追加される）
	 * （maxNumberOfDiagonalListの0番目は左上から右下の最大値、1番目は右上から左下の最大値が追加される）
	 *
	 * -----実行結果-----
	 * 各行の最大値
		1行:21
		2行:96
		3行:41
		4行:83
		各列の最大値
		1列:61
		2列:83
		3列:65
		4列:96
		各対角のの最大値(1:左上から右下、2:右上から左下)
		対角1:71
		対角2:65

	 */

	public static void main(String[] args) {
		List<List<Integer>> twoDimentionalList = Arrays.asList(
				Arrays.asList(21, 3, 15, 12),
				Arrays.asList(32, 71, 65, 96),
				Arrays.asList(11, 6, 41, 9),
				Arrays.asList(61, 83, 54, 27));
		final int ROW = twoDimentionalList.size();
		final int COLUMN = twoDimentionalList.get(0).size();
		List<Integer> maxNumberOfRowList = new ArrayList<>();
		List<Integer> maxNumberOfColumnList = new ArrayList<>();
		List<Integer> maxNumberOfDiagonalList = new ArrayList<>();

		//ここから

		//ここまで

		System.out.println("各行の最大値");
		for (int i = 0; i < maxNumberOfRowList.size(); i++) {
			System.out.println(String.format("%d行:%d", i + 1, maxNumberOfRowList.get(i)));
		}
		System.out.println("各列の最大値");
		for (int i = 0; i < maxNumberOfColumnList.size(); i++) {
			System.out.println(String.format("%d列:%d", i + 1, maxNumberOfColumnList.get(i)));
		}
		System.out.println("各対角のの最大値(1:左上から右下、2:右上から左下)");
		for (int i = 0; i < maxNumberOfDiagonalList.size(); i++) {
			System.out.println(String.format("対角%d:%d", i + 1, maxNumberOfDiagonalList.get(i)));
		}
	}

}
