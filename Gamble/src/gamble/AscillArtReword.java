package gamble;
//package miniproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class AscillArtReword {
	public void reword01() throws IOException {			 // 그림 txt?��?���? ???�� 

		Writer out = new FileWriter("AscilArtV.txt");
		BufferedWriter bOut = new BufferedWriter(out);

		String[] array_v = new String[51];
		array_v[0] = ("                                    `...`                             `....`                        ");
		array_v[1] = ("                                `:://://++/-`                      `-:///:////-`                    ");
		array_v[2] = ("                              `:/:-.-:::://+/.                    -//:.```-::/+/-`                  ");
		array_v[3] = ("                             `//:`  `-:::://++-                 `:/:-`   .-::://+-                  ");
		array_v[4] = ("                             :+:-   `-::::://++.               `//:-.  `.-:::://++`                 ");
		array_v[5] = ("                             //:-   .-:::::://+:`             `//::-` `-::::::///+-                 ");
		array_v[6] = ("                             :/:-`  .::::::://++.             :+:::. `-:::::::///+-                 ");
		array_v[7] = ("                             -+::.  .:::::::///+-            .+/::-``-::::::::///+-                 ");
		array_v[8] = ("                             `+::-` .:::::::://+/           `/+:::.`.:::::::::/:/+.                 ");
		array_v[9] = ("                              //::. `-::::::://++`          .+/::-``-:::::::://:/+`                 ");
		array_v[10] = ("                              .+::-``-:::::::///+.          -+:::.`-::::::::///:+/                  ");
		array_v[11] = ("                               //::. -:::::::://+-          //-:-`.-:::::::://:/+-                  ");
		array_v[12] = ("                               -+::-`.:::::::://+:          +/::-`-::::::::://:+/`                  ");
		array_v[13] = ("                               `//::..:::::::://+/`        `+:::..:::::::::////+-                   ");
		array_v[14] = ("                                -+::-`-:::::::///+.        .+::-`-:::::::::////+`                   ");
		array_v[15] = ("                                `+/::`.:::::::://+-        :/::..:::::::::////+-                    ");
		array_v[16] = ("                                 -+::.`-::::::://+:        //::--::::::::://://`                    ");
		array_v[17] = ("                                 `//:-`.::::::://+/       `+/::::::::::::////+-                     ");
		array_v[18] = ("                                  -+::.`::::::::/++`      .+::::::::::::://://`                     ");
		array_v[19] = ("                                  `//:-.:::::::://+.      -+::::::::::::://:+-                      ");
		array_v[20] = ("                                   -+::-:::::::::/+:      :+::::::::::::////:                       ");
		array_v[21] = ("                                   `//:::::::::::/+/`    `//:::::::::::://:/-                       ");
		array_v[22] = ("                                    -/::::::::::://+-    `+:::::::::::::/::+`                       ");
		array_v[23] = ("                                    `//:::::::::://+/`   :+:::::::::::://:/+                        ");
		array_v[24] = ("                             `.-:://:+/::::::::::///+-  .+/:::::::::::://://                        ");
		array_v[25] = ("                            .//:::::/++/:::::::://////::+/::::::::::::///:+:                        ");
		array_v[26] = ("                           `/::::::::::++/////////::::://////:::::::::///:+:                        ");
		array_v[27] = ("                           -/:::::::::::/+::::::::--:------:::::::::::///:+/                        ");
		array_v[28] = ("                  `.-://:-`-+/:::::::::::/+::::::/:::::::::::::::::::::///++`                       ");
		array_v[29] = ("                 .///:::://++//:::::::::::/+::::/+/:::::::::::::::::::::///+-                       ");
		array_v[30] = ("                 //:::::::::/+///::::::::::/+:::/+/::::::::::////:::::::://+/`                      ");
		array_v[31] = ("                `+/::::::::::/+//:::::::::::////+/::::::://///::::::::::::/++.                      ");
		array_v[32] = ("                 /+/:::::::::::///:::::::::::+//+/:::://///::--------::::::/o:                      ");
		array_v[33] = ("                 /++/:::::::::::/+/::::--.--:/++++//++++/:----:::::::::::::/++                      ");
		array_v[34] = ("                 ///+/::::::::::::///:-.....-/+//:::::://+//:::::::::::::://++`                     ");
		array_v[35] = ("                 :/:/+//::::::::-::///-...../+:-........--:://///::::::::////+.                     ");
		array_v[36] = ("                 .+:::++/::::-....-:/+:....-+/-..........------::///:::::////+.                     ");
		array_v[37] = ("                 `//:::/+/:/:..`....-//:---:+/:..........-:--------://///////+.                     ");
		array_v[38] = ("                  -+:::::///:-.`..`.-/++////+++:--.....--:::::--------:://///+`                     ");
		array_v[39] = ("                  `//:::::////:-...-:/+//:/:/++++/::--::::::::::::-------://++`                     ");
		array_v[40] = ("                   .+/::::::://////////:::::/+/:/++//::::::::::::::::----://+:                      ");
		array_v[41] = ("                    :+::::::::::////:::::::/++::::://++//:::::::::::::::::///.                      ");
		array_v[42] = ("                    `:/::::/:::::::::::::::/+/::::::::://////:::::::::::://+-                       ");
		array_v[43] = ("                     `//:--::::::::::::::::/+/:::::::::::::////::::::::://+:`                       ");
		array_v[44] = ("                      `/+:----:::::::::::::/+/:::::::::::///////::::::::/+:`                        ");
		array_v[45] = ("                       `:+:------:::::::::://:::::::://///////////////://-`                         ");
		array_v[46] = ("                        `-//:---..-------:://:::////////////////+///////.                           ");
		array_v[47] = ("                          `-//:---------..-///////////////////////////-`                            ");
		array_v[48] = ("                            `.://:---------/////////////////////////-`                              ");
		array_v[49] = ("                               `-:///::::://////////////////////:-.`                                ");
		array_v[50] = ("                                   `.-::::::----...``                                               ");
		for (int i = 0; i < array_v.length; i++) {
			bOut.write(array_v[i] + "\n");
		}

		bOut.close(); // 3�떒?�� �뒪�듃?���? �떕湲�
	}

	public void reword02() throws IOException {        // 그림 txt?��?���? ???�� 
		Writer out = new FileWriter("AscilArtLike.txt");
		BufferedWriter bOut = new BufferedWriter(out);

		String[] array_like = new String[31];
		array_like[0] = ("                                                   `:+o+/-                                          ");
		array_like[1] = ("                                                   shhhhhhy-                                        ");
		array_like[2] = ("                                                  `hhhhhhhhh:                                        ");
		array_like[3] = ("                                                  `hhhhhhhhhy.                                       ");
		array_like[4] = ("                                                  .hhhhhhhhhh+                                      ");
		array_like[5] = ("                                                  /hhhhhhhhhhs                                      ");
		array_like[6] = ("                                                 /hhhhhhhhhhhy                                      ");
		array_like[7] = ("                                              `ohhhhhhhhhhhhs                                         ");
		array_like[8] = ("                                              .shhhhhhhhhhhhh+                                          ");
		array_like[9] = ("                                             :yhhhhhhhhhhhhhh.                                             ");
		array_like[10] = ("                                        	/yhhhhhhhhhhhhhho                                           ");
		array_like[11] = ("                                          `ohhhhhhhhhhhhhhhhsoooooooooooooooooo++:.                 ");
		array_like[12] = ("                                         .shhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhy/                	");
		array_like[13] = ("              ./+oooooooooooooo+:`    :yhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh-               ");
		array_like[14] = ("               `yhhhhhhhhhhhhhhhhhhs   +hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh-               ");
		array_like[15] = ("               -hhhhhhhhhhhhhhhhhhhy  -hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhs:                ");
		array_like[16] = ("              -hhhhhhhhhhhhhhhhhhhy  /hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh+`                 ");
		array_like[17] = ("               -hhhhhhhhhhhhhhhhhhhy  /hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh/                 ");
		array_like[18] = ("               -hhhhhhhhhhhhhhhhhhhy  /hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhy                 ");
		array_like[19] = ("               -hhhhhhhhhhhhhhhhhhhy  /hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhy/                 ");
		array_like[20] = ("               -hhhhhhhhhhhhhhhhhhhy  /hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhy+-                  ");
		array_like[21] = ("               -hhhhhhhhhhhhhhhhhhhy  /hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhy:                   ");
		array_like[22] = ("               -hhhhhhhhhhhhhhhhhhhy  /hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh.                  ");
		array_like[23] = ("               -hhhhhhhhhhhhhhhhhhhy  /hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh.                  ");
		array_like[24] = ("               -hhhhhhhhhhhhhhhhhhhy  /hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhy:                   ");
		array_like[25] = ("                -hhhhhhhhhhhhhhhhhhhy  /hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhy:`                    ");
		array_like[26] = ("               -hhhhhhhhhhhhhhhhhhhy  :hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhs`                    ");
		array_like[27] = ("               -hhhhhhhhhhhhhhhhhhhy   +hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh-                    ");
		array_like[28] = ("               .hhhhhhhhhhhhhhhhhhhy    -shhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhs`                    ");
		array_like[29] = ("                /syyyyyyyyyyyyyyyys-      -oyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyys/`                     ");
		array_like[30] = ("                   ``````````````            `............................``                        ");
		for (int i = 0; i < array_like.length; i++) {
			bOut.write(array_like[i] + "\n");
		}

		bOut.close();
	}

	public String[] ReaderLike() throws IOException {
		Reader in = new FileReader("AscilArtLike.txt");
		BufferedReader bIn = new BufferedReader(in);
		String[] str = new String[31];
		AscillArtReword reword = new AscillArtReword();
		for (int i = 0; i < str.length; i++) {
			str[i] = bIn.readLine();
		}

		bIn.close();
		return str;
	}

	public String[] ReaderV() throws IOException {
		Reader in = new FileReader("AscilArtV.txt");
		BufferedReader bIn = new BufferedReader(in);
		String[] str = new String[51];
		for (int i = 0; i < str.length; i++) {
			str[i] = bIn.readLine();

		}

		bIn.close();
		return str;

	}

//	public static void main(String[] args) throws IOException {
//		AscillArtReword reword = new AscillArtReword();
//
//		reword.Reword01();
//		reword.Reword02();
//		
//		String[] arr01 =reword.ReaderLike();
//		for(int i=0;i<arr01.length;i++) {
//			System.out.println(arr01[i]);
//		}
//		
//		String[] arr02 = reword.ReaderV();
//		for(int i=0;i<arr02.length;i++) {
//			System.out.println(arr02[i]);
//		}
//	
//
//	}

}
