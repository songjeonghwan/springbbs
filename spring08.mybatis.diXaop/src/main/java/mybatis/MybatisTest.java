/*package mybatis;

import java.util.Scanner;

import mybatis.service.IServiceBoard;
import mybatis.service.ServiceBoard;

/**
 * Created by Administrator on 2016-10-27.
 */
/*
public class MybatisTest {

    public static void main(String[] args) {

        int userChoice = 0 ;

        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Choose from these choices");
            System.out.println("------------------------------");
            System.out.println(" 0 - getBoardName           ");
            System.out.print  ("input a number >> ");

            userChoice = input.nextInt();

            // connection 설정
            IServiceBoard service = new ServiceBoard();

            switch (userChoice) {
                case 0:
                    // select 테스트
                    String result = service.getBoardName("free");

                    System.out.println(result);
                default:
                    // The user input an unexpected choice.
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            input.close();
        }
    }

    public void printResultSet() {

    }
}
*/