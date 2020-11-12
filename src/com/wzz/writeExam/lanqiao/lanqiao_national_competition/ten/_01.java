package com.wzz.writeExam.lanqiao.lanqiao_national_competition.ten;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Date 2020/11/11 9:28
 * @created by wzz
 * <p>
 * 对于一个字母矩阵，我们称矩阵中的一个递增序列是指在矩阵中找到两个
 * 字母，它们在同一行，同一列，或者在同一 45 度的斜线上，这两个字母从左向
 * 右看、或者从上向下看是递增的。
 * 例如，如下矩阵中
 * LANN
 * QIAO
 * 有LN、 LN、 AN、 AN、 IO、 AO、 LQ、 AI、 NO、 NO、 AQ、 IN、 AN 等 13 个
 * 递增序列。注意当两个字母是从左下到右上排列时，从左向右看和从上向下看
 * 是不同的顺序。
 * 对于下面的 30 行 50 列的矩阵，请问总共有多少个递增序列？（如果你把
 * 以下文字复制到文本文件中，请务必检查复制的内容是否与文档中的一致。在
 * 试题目录下有一个文件 inc.txt，内容与下面的文本相同）
 * VLPWJVVNNZSWFGHSFRBCOIJTPYNEURPIGKQGPSXUGNELGRVZAG
 * SDLLOVGRTWEYZKKXNKIRWGZWXWRHKXFASATDWZAPZRNHTNNGQF
 * ZGUGXVQDQAEAHOQEADMWWXFBXECKAVIGPTKTTQFWSWPKRPSMGA
 * BDGMGYHAOPPRRHKYZCMFZEDELCALTBSWNTAODXYVHQNDASUFRL
 * YVYWQZUTEPFSFXLTZBMBQETXGXFUEBHGMJKBPNIHMYOELYZIKH
 * ZYZHSLTCGNANNXTUJGBYKUOJMGOGRDPKEUGVHNZJZHDUNRERBU
 * XFPTZKTPVQPJEMBHNTUBSMIYEGXNWQSBZMHMDRZZMJPZQTCWLR
 * ZNXOKBITTPSHEXWHZXFLWEMPZTBVNKNYSHCIQRIKQHFRAYWOPG
 * MHJKFYYBQSDPOVJICWWGGCOZSBGLSOXOFDAADZYEOBKDDTMQPA
 * VIDPIGELBYMEVQLASLQRUKMXSEWGHRSFVXOMHSJWWXHIBCGVIF
 * GWRFRFLHAMYWYZOIQODBIHHRIIMWJWJGYPFAHZZWJKRGOISUJC
 * EKQKKPNEYCBWOQHTYFHHQZRLFNDOVXTWASSQWXKBIVTKTUIASK
 * PEKNJFIVBKOZUEPPHIWLUBFUDWPIDRJKAZVJKPBRHCRMGNMFWW
 * CGZAXHXPDELTACGUWBXWNNZNDQYYCIQRJCULIEBQBLLMJEUSZP
 * RWHHQMBIJWTQPUFNAESPZHAQARNIDUCRYQAZMNVRVZUJOZUDGS
 * PFGAYBDEECHUXFUZIKAXYDFWJNSAOPJYWUIEJSCORRBVQHCHMR
 * JNVIPVEMQSHCCAXMWEFSYIGFPIXNIDXOTXTNBCHSHUZGKXFECL
 * YZBAIIOTWLREPZISBGJLQDALKZUKEQMKLDIPXJEPENEIPWFDLP
 * HBQKWJFLSEXVILKYPNSWUZLDCRTAYUUPEITQJEITZRQMMAQNLN
 * DQDJGOWMBFKAIGWEAJOISPFPLULIWVVALLIIHBGEZLGRHRCKGF
 * LXYPCVPNUKSWCCGXEYTEBAWRLWDWNHHNNNWQNIIBUCGUJYMRYW
 * CZDKISKUSBPFHVGSAVJBDMNPSDKFRXVVPLVAQUGVUJEXSZFGFQ
 * IYIJGISUANRAXTGQLAVFMQTICKQAHLEBGHAVOVVPEXIMLFWIYI
 * ZIIFSOPCMAWCBPKWZBUQPQLGSNIBFADUUJJHPAIUVVNWNWKDZB
 * HGTEEIISFGIUEUOWXVTPJDVACYQYFQUCXOXOSSMXLZDQESHXKP
 * FEBZHJAGIFGXSMRDKGONGELOALLSYDVILRWAPXXBPOOSWZNEAS
 * VJGMAOFLGYIFLJTEKDNIWHJAABCASFMAKIENSYIZZSLRSUIPCJ
 * BMQGMPDRCPGWKTPLOTAINXZAAJWCPUJHPOUYWNWHZAKCDMZDSR
 * RRARTVHZYYCEDXJQNQAINQVDJCZCZLCQWQQIKUYMYMOVMNCBVY
 * ABTCRRUXVGYLZILFLOFYVWFFBZNFWDZOADRDCLIRFKBFBHMAXX
 */
public class _01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = new String[30];
        for (int i = 0; i < 30; i++) {
            input[i] = scanner.nextLine().trim();
        }
        //计数
        int sum = 0;
        //根据题目的实例的样例 得到五个可用方向  向左 向右 右下 左下 右上
        int[][] direction = {{1, 0}, {0, 1}, {1, 1}, {-1, 1}, {1, -1}};
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 50; j++) {

                for (int k = 0; k < 5; k++) {//方向变化
                    int x = i, y = j;//当前双重循环选中的数字,拷贝通过新规则然后与原位置对比
                    while (true) {
                        x += direction[k][0];
                        y += direction[k][1];
                        if (x < 0 || x >= 30 || y < 0 || y >= 50) {//退出条件
                            break;
                        }
                        if (input[x].charAt(y) > input[i].charAt(j))//当前的选中的数字 满足 小于 双重循环的数字
                            sum++;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
