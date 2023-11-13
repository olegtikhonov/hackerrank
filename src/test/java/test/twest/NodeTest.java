package test.twest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.twest.test.twest.hackerrank.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NodeTest {

	@BeforeEach
	public void setUp() throws Exception {
	}

	@Test
	public void testNode() {
		String data = "first";
		Node<String> test = new Node(data);
	}

//	@Test
//    public void testPow() {
//	    int x = 2;
//	    int n = 3;
//
//        int result = Math.pow(3, 2);
//        System.out.println("Result:=" + result);
//    }

//    @Test
//    public void testHurdleRace() {
//	    // case 1: 5 4
//        //         1 6 3 5 2
//        int k = 4;
//        int[] height = {1, 6, 3, 5, 2};
//        System.out.println(HurdleRace.hurdleRace(k, height));
//
//        // case 2:
//        k = 7;
//        int[] newHeight = {2, 5, 4, 5, 2};
//        System.out.println(HurdleRace.hurdleRace(k, newHeight));
//    }

    @Test
    public void testDivisibleSumPairs() {
	    int n = 6;
	    int k = 3;
	    int[] ar = {1, 3, 2, 6, 1, 2};

        int result = DivisibleSumPairs.divisibleSumPairs(n, k, ar);
        System.out.println(result);
    }

    @Test
    public void testCatAndMouse() {
        String resCase1 = CatAndMouse.catAndMouse(1,2, 3);
        System.out.println(resCase1);

        String resCase2 = CatAndMouse.catAndMouse(1,3, 2);
        System.out.println(resCase2);

    }

    @Test
    public void testSockMerchant() {
	    int n = 9;
        int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        int result = SockMerchant.sockMerchant(n, ar);
        System.out.println(result);
    }

    @Test
    public void testBreakingRecords() {
	    // case 1:
        int[] case1 = {10, 5, 20, 20, 4, 5, 2, 25, 1};
        System.out.println(Arrays.toString(BreakingRecords.breakingRecords(case1)));
        int[] case2 = {3, 4, 21, 36, 10, 28, 35, 5, 24, 42};
        System.out.println(Arrays.toString(BreakingRecords.breakingRecords(case2)));
        // case 3:
        int[] case3 = {12, 24, 10, 24};
        System.out.println(Arrays.toString(BreakingRecords.breakingRecords(case3)));
    }

    @Test
    public void testCamelCase() {
	    String input = "saveChangesInTheEditor";
        System.out.println(CamelCase.camelcase(input));

        input = "savechangesintheeditor";
        System.out.println(CamelCase.camelcase(input));
    }

    @Test
    public void testEqualizeArray() {
	    int[] ar = {3, 3, 2, 1, 3};
        System.out.println(EqualizeArray.equalizeArray(ar));

        int[] case2 = {78, 39, 34, 6, 78, 78, 36, 78, 34, 36, 78, 39, 36, 75, 95, 36, 72, 34, 75, 78, 6, 36, 95, 72, 75, 75, 75, 10, 10, 78, 6, 78, 72, 34, 34, 34, 36, 34, 78, 78, 36, 10, 6, 6, 36, 78, 72, 78, 75, 36, 78, 72, 10, 34, 72, 95, 39, 36, 95, 72, 10, 78, 72, 39, 6, 39, 10, 6, 39, 78, 95, 78, 95, 10, 34, 39, 78, 34, 34, 95, 10, 10, 6, 39, 78, 95, 36, 10, 39, 78, 36, 78, 75, 36, 36, 39, 78, 95};
        System.out.println(EqualizeArray.equalizeArray(case2));

        int[] case3 = {10, 27, 9, 10, 100, 38, 30, 32, 45, 29, 27, 29, 32, 38, 32, 38, 14, 38, 29, 30, 63, 29, 63, 91, 54, 10, 63};
        System.out.println(EqualizeArray.equalizeArray(case3));

        int[] case4 = {35, 65, 69, 28, 12, 69, 37, 80, 80, 50, 80, 50, 15, 57, 79, 69, 57, 65, 15, 69, 57, 50, 65, 2, 14, 64, 15, 65, 65, 5, 15, 64, 57, 37, 50, 12, 64, 37, 28, 20, 80, 80, 50};
        System.out.println(EqualizeArray.equalizeArray(case4));
    }

    @Test
    public void testMigratoryBirds() {
	    int n = 6;
        int[] ar = {1, 4, 4, 4, 5, 3};
        System.out.println(MigratoryBirds.migratoryBirds(n, ar));

        int[] case2 = {1, 4, 4, 5, 5, 3, 2, 2};
        System.out.println(MigratoryBirds.migratoryBirds(n, case2));
    }

    @Test
    public void testMarsExploration() {
//	    String input = "SOSSOSSOS";
//        System.out.println(MarsExploration.marsExploration(input));
//
        String input = "SOSSOSSSSOSOIEISOSPOISOSIUSISO";
        System.out.println(MarsExploration.marsExploration(input));
//
//        input = "SOSSOT";
//        System.out.println(MarsExploration.marsExploration(input));

//        String input = "SOS OOS OSO SOS OSS OSO SOS OSO SOS";
//        String[] in = input.split(" ");
//        int counter = 0;
//        for(String s : in) {
//            counter += MarsExploration.damLevDist("SOS", s);
//            System.out.println(counter);
//        }
    }

    @Test
    public void testGetMoneySpent() {
	    int[] keyborads = {5};
	    int[] drives = {4};
	    int budget = 5;
        System.out.println(ElectronicsShop.getMoneySpent(keyborads, drives, budget));

        // case 2:
        int[] keyCase2 = {3, 1};
        int[] driveCase2 = {5, 2, 8};
        budget = 10;
        System.out.println(ElectronicsShop.getMoneySpent(keyCase2, driveCase2, budget));
    }

    @Test
    public void testButifulDay() {
        //20 23 6
        System.out.println(BeautifulDays.beautifulDays(20, 23, 6));
        //49860 205494 155635764 --> 607
        System.out.println(BeautifulDays.beautifulDays(49860, 205494, 155635764));

    }

    @Test
    public void testFindDigits() {
	    int case1 = 12;
	    FindDigits.findDigits(case1);
	    int case2 = 1012;
        FindDigits.findDigits(case2);
    }

    @Test
    public void testCountingSort() {
	    int[] case1 = {63, 25, 73, 1, 98, 73, 56, 84, 86, 57, 16, 83, 8, 25, 81, 56, 9, 53, 98, 67, 99, 12, 83, 89, 80, 91, 39, 86, 76, 85, 74, 39, 25, 90, 59, 10, 94, 32, 44, 3, 89, 30, 27, 79, 46, 96, 27, 32, 18, 21, 92, 69, 81, 40, 40, 34, 68, 78, 24, 87, 42, 69, 23, 41, 78, 22, 6, 90, 99, 89, 50, 30, 20, 1, 43, 3, 70, 95, 33, 46, 44, 9, 69, 48, 33, 60, 65, 16, 82, 67, 61, 32, 21, 79, 75, 75, 13, 87, 70, 33};
        int[] result  = CountingSort.countingSort(case1);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testSherlockAndSquares() {
	    int a = 17;
	    int b = 24;
        System.out.println(SherlockAndSquares.squares(a, b));
        System.out.println(SherlockAndSquares.test(a, b));
        //178809602 330598161
//        System.out.println(SherlockAndSquares.squares(178809602, 330598161));
        System.out.println(SherlockAndSquares.test(178809602, 330598161));
    }

    @Test
    public void testJumpingOnTheClouds() {
        int[] input = {0, 0, 1, 0, 0, 1, 0};
        System.out.println(JumpingOnTheClouds.jumpingOnClouds(input));
        int[] case2 = {0, 0, 0, 0, 1, 0};
        System.out.println(JumpingOnTheClouds.jumpingOnClouds(case2));
    }

    @Test
    public void testRepeatedString() {
	    String aStr = "a";
	    long n = 1000000000000l;
        System.out.println(RepeatedString.repeatedString(aStr, n));
    }

    @Test
    public void testCountingValleys() {
	    int numberOfHills = 8;
	    String case1 = "UDDDUDUU";
        System.out.println(CountingValleys.countingValleys(numberOfHills, case1));

	    String case2 = "UDUDUD";
        System.out.println(CountingValleys.countingValleys(case2.length(), case2));

        String case3 = "UDUUUDUDDD";
        System.out.println(CountingValleys.countingValleys(case3.length(), case3));
    }

    @Test
    public void testKangaroo() {
	    //0 3 4 2
	    int x1 = 0, v1 = 3, x2 = 4, v2 = 2;
        System.out.println(Kangaroo.kangaroo(x1, v1, x2, v2));
        //0 2 5 3
        System.out.println(Kangaroo.kangaroo(0, 2, 5, 3));

        //4523 8092 9419 8076
        System.out.println(Kangaroo.kangaroo(4523, 8092, 9419, 8076));
    }

    @Test
    public void testAngryProfessor() {
	    int k = 3;
        int[] case1 = {-1, -3, 4, 2};
        System.out.println(AngryProfessor.angryProfessor(k, case1));

        k = 2;
        int[] case2 = {0, -1, 2, 1};
        System.out.println(AngryProfessor.angryProfessor(k, case2));
    }

    @Test
    public void testJumpingCloudsRevisited() {
	    int k = 2;
	    int[] clouds = {0, 0, 1, 0, 0, 1, 1, 0, };
        System.out.println(JumpingCloudsRevisited.jumpingOnClouds(clouds, k));
    }

    @Test
    public void testMinimumDistances() {
        int[] input = {3, 2, 1, 2, 3};
        System.out.println(MinimumDistances.minimumDistances(input));

        // case 2:
        int[] case2 = {1, 2, 3, 4, 10};
        System.out.println(MinimumDistances.minimumDistances(case2));
    }

    @Test
    public void testMaximumToys() {
        int[] prices = {1, 12, 5, 111, 200, 1000, 10};
        System.out.println(MaximumToys.maximumToys(prices, 50));
    }

    @Test
    public void testDrawingBook() {
        int n = 6, p = 2;
        System.out.println(DrawingBook.pageCount(n, p));
    }

    @Test
    public void testChocolateFeast() {
	    int n = 10, c = 2, m = 5;
        System.out.println(ChocolateFeast.chocolateFeast(n,c,m));

        // case 2 12 4 4
        System.out.println(ChocolateFeast.chocolateFeast(12,4,4));
        // case 3 6 2 2
        System.out.println(ChocolateFeast.chocolateFeast(6,2,2));

        // case 4 54787 50580 16437 (1)
        System.out.println(ChocolateFeast.chocolateFeast(54787,50580,16437));

        // case 5 97757 809 94103 (120)
        System.out.println(ChocolateFeast.chocolateFeast(97757,809,94103));

        // case 16779 1 5886
        System.out.println(ChocolateFeast.chocolateFeast(16779,1,5886));
    }

//    @Test
//    public void testLessonOne() {
//	    Preparation.lessonOne();
//    }

    @Test
    public void testCreateTree() {
	    BinaryTree example = new BinaryTree();
        Random generator = new Random();

        for(int i = 0; i < 10; i++) {
            example.add(generator.nextInt(100));
        }

        BTreeNode root = example.getRoot();
        //example.showTree(root);


        // traverseLevelOrder
        //example.traverseLevelOrder();

        // height
        System.out.println(example.height(root));
    }

    @Test
    public void testPreparation() {
        System.out.println(Preparation.calculateFibonachi(9));
    }

    @Test
    public void testAlternatingCharacters() {
	    String s = "AAAA";
        System.out.println(AlternatingCharacters.alternatingCharacters(s));

        s = "BBBBB";
        System.out.println(AlternatingCharacters.alternatingCharacters(s));

        s = "ABABABAB";
        System.out.println(AlternatingCharacters.alternatingCharacters(s));

        s = "BABABA";
        System.out.println(AlternatingCharacters.alternatingCharacters(s));

        s = "AAABBB";
        System.out.println(AlternatingCharacters.alternatingCharacters(s));
    }

    @Test
    public void testUtopianTree() {
	    // case 1 n = 0, expected = 1
	    int result = UtopianTree.utopianTree(0);
        System.out.println(result);

        result = UtopianTree.utopianTree(1);
        System.out.println(result);

        result = UtopianTree.utopianTree(2);
        System.out.println(result);

        result = UtopianTree.utopianTree(3);
        System.out.println(result);

        result = UtopianTree.utopianTree(4);
        System.out.println(result);

        result = UtopianTree.utopianTree(60);
        System.out.println(result);
    }

    @Test
    public void testCutTheSticks() {
	    int[] input = {5, 4, 4, 2, 2, 8};
	    int[] result = CutTheSticks.cutTheSticks(input);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testBeautifulTriplets() {
	    int d = 3;
        int[] case1 = {1, 2, 4, 5, 7, 8, 10};
	    int result = BeautifulTriplets.beautifulTriplets(d, case1);
        System.out.println(result);

        result = BeautifulTriplets.efficientSolution(d, case1);
        System.out.println(result);
    }

    @Test
    public void testMakingAnagrams() {
	    String s1 = "cde";
        String s2 = "abc";
        int result = MakingAnagrams.makingAnagrams(s1, s2);

        System.out.println(result);
        // case 2
        s1 = "fcrxzwscanmligyxyvym";
        s2 = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        result = MakingAnagrams.makingAnagrams(s1, s2);
        System.out.println(result);
    }

    @Test
    public void testLonelyInteger() {
        int[] a = {1, 1, 2};
	    int result = LonelyInteger.lonelyinteger(a);
        System.out.println(result);
        int[] case2 = {0, 0, 1, 2, 1};
        result = LonelyInteger.lonelyinteger(case2);
        System.out.println(result);
    }

    @Test
    public void testGradingStudents() {
        int[] input = {4, 73, 67, 38, 33};
        int[] result = GradingStudents.gradingStudents(input);
        System.out.println(Arrays.toString(result));

    }

    @Test
    public void testPangrams() {
	    String case1 = "We promptly judged antique ivory buckles for the next prize";
        System.out.println(Pangrams.pangrams(case1));
        String case2 = "We promptly judged antique ivory buckles for the prize";
        System.out.println(Pangrams.pangrams(case2));
    }

    @Test
    public void testInsertionSortPart2() {
	    int nCase1 = 6;
        int[] case1 = {1, 4, 3, 5, 6, 2};
	    InsertionSortPart2.insertionSort2(nCase1, case1);
    }

    @Test
    public void testInsertionSortWithError() {
        int[] case1 = {7, 4, 3, 5, 6, 2};
        InsertionSortPart2.insertionSort(case1);
    }

    @Test
    public void testSavePrisoner() {
	    int n = 5;
	    int m = 2;
	    int s = 1;
        System.out.println(SavePrisoner.saveThePrisoner(n, m, s));
        System.out.println(SavePrisoner.saveThePrisoner(n, m, 2));
    }

    @Test
    public void testCountingSort1() {
	    int[] input = {63, 25, 73, 1, 98, 73, 56, 84, 86, 57, 16, 83, 8, 25};
	    int[] result = CountingSort1.countingSort(input);
    }

    @Test
    public void testArrayManipulation() {
	    int n = 5;
	    //int c = 7542539201;
	    int[][] input = {{1, 2, 100}, {2, 5, 100}, {3, 4, 100}};
        System.out.println(ArrayManipulation.arrayManipulation(n, input));
    }

    @Test
    public void testFormingAMagicSquare() {
	    int [][] input = {{5, 3, 4}, {1, 5, 8}, {6, 4, 2}};
        System.out.println(FormingAMagicSquare.transpose(input));
        int[][] s = FormingAMagicSquare.generateMagicSquare(3);
        System.out.println(s);
        System.out.println(FormingAMagicSquare.formingMagicSquare(input));
    }

    @Test
    public void testclimbingLeaderboard() {
        int[] scores = {100, 100, 50, 40, 40, 20, 10};
        int[] alice = {5, 25, 50, 120};
	    int[] ranks = ClimbingTheLeaderboard.climbingLeaderboard(scores, alice);
        System.out.println(ranks);
    }

    @Test
    public void testDesignerPdfViewer() {
        int[] heights = {1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        String w = "abc";
        System.out.println(DesignerPdfViewer.designerPdfViewer(heights, w));

        // case 2
        int[] case2 = {1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7};
        w = "zaba";
        System.out.println(DesignerPdfViewer.designerPdfViewer(case2, w));
    }

    @Test
    public void testCircularArrayRotation() {
	    int[] a = {1, 2, 3};
	    int k = 2;
	    int[] m = {0, 1, 2};
	    int[] result = CircularArrayRotation.circularArrayRotation(a, k, m);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testPermutationEquation() {
	    int[] array = {2, 3, 1};
	    PermutationEquation.permutationEquation(array);
    }

    @Test
    public void testExtraLongFactorials() {
	    ExtraLongFactorials.extraLongFactorials(50);
    }

    @Test
    public void testNonDivisibleSubset() {
//	    int k = 3;
//        int[] S = {1, 2, 7, 4};
//        NonDivisibleSubset.nonDivisibleSubset(k, S);
//
        int[] case2 = {1, 2, 3, 4, 5};
        NonDivisibleSubset.nonDivisibleSubset(1, case2);

        int[] case3 = {770528134, 663501748, 384261537, 800309024, 103668401, 538539662, 385488901, 101262949, 557792122, 46058493};
        System.out.println(NonDivisibleSubset.nonDivisibleSubset(5, case3));
    }

    @Test
    public void testQueenAttack2() {
        QueenAttack2.Tuple queen = new QueenAttack2.Tuple(4,0);
        List<QueenAttack2.Tuple> result = QueenAttack2.getPossibleSteps(4, queen, QueenAttack2.STEPS.UP);

        queen = new QueenAttack2.Tuple(4,4);
        result = QueenAttack2.getPossibleSteps(4, queen, QueenAttack2.STEPS.DOWN);

        queen = new QueenAttack2.Tuple(4,4);
        result = QueenAttack2.getPossibleSteps(4, queen, QueenAttack2.STEPS.LEFT);

        queen = new QueenAttack2.Tuple(0,4);
        result = QueenAttack2.getPossibleSteps(4, queen, QueenAttack2.STEPS.RIGHT);

        queen = new QueenAttack2.Tuple(4,1);
        result = QueenAttack2.getPossibleSteps(4, queen, QueenAttack2.STEPS.LEFT_UP);

    }

    @Test
    public void testAcmIcpcTeam() {
	    String[] topics = {"10101", "11100", "11010", "00101"};
	    int[] result = AcmIcpcTeam.acmTeam(topics);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testEncryption() {
	    String input = "if man was meant to stay on the ground god would have given us roots";
        System.out.println(Encryption.encryption(input));

        // case 2
        input = "haveaniceday";
        System.out.println(Encryption.encryption(input));

        // case 3:
        input = "chillout";
        System.out.println(Encryption.encryption(input));
    }

    @Test
    public void testBiggerIsGreater() {
	    String w = "ab";
        String result = BiggerIsGreater.permute(w);
        System.out.println(result);

        // case 2
        w = "bb";
        String resCase2 = BiggerIsGreater.permute(w);
        System.out.println(resCase2);

        // case 3
        w = "hefg";
        result = BiggerIsGreater.permute(w);
        System.out.println(result);

        // case 4
        w = "dhkc";
        System.out.println(BiggerIsGreater.biggerIsGreater(w));


        result = BiggerIsGreater.permute(w);
        System.out.println(result);

        System.out.println("dhkc".compareTo("dhck"));

//        BiggerIsGreater.printPermutations(w.toCharArray());


        w = "hcdk";
        System.out.println(BiggerIsGreater.biggerIsGreater(w));
    }

    @Test
    public void testKaprekarNumbers() {
        KaprekarNumbers.kaprekarNumbers(400, 700);
        int[] result = KaprekarNumbers.kaprekarNumbers(1000, 10000);
        System.out.println(result);
    }

    @Test
    public void testHalloweenSale() {
	    // 20 3 6 80
        System.out.println(HalloweenSale.howManyGames(20, 3, 6, 80));
        // 20 3 6 85
    }

    @Test
    public void testFlatlandSpaceStations() {
        FlatlandSpaceStations.flatlandSpaceStations(6, new int[] {0, 1, 2, 4, 3, 5});
    }

    @Test
    public void testFairRatations() {
	    // case 1: 4
        System.out.println(FairRations.fairRations(new int[]{2, 3, 4, 5, 6}));

        // case 2:
        System.out.println(FairRations.fairRations(new int[]{1, 2}));
    }

    @Test
    public void testManasaAndStones() {
	    int[] case1 = ManasaAndStones.stones(3,1,2);
        System.out.println(Arrays.toString(case1));

        int[] case2 = ManasaAndStones.stones(4,10,100);
        System.out.println(Arrays.toString(case2));
    }

    @Test
    public void testGridSearch() {
	    String[] grid = {"1234567890", "0987654321", "1111111111", "1111111111", "2222222222" };
	    String[] pattern = {"876543", "111111", "111111"};
        System.out.println(GridSearch.gridSearch(grid, pattern));

        // case 2
        String[] case2 = {"400453592126560", "114213133098692", "474386082879648", "522356951189169", "887109450487496",
                          "252802633388782", "502771484966748", "075975207693780", "511799789562806", "404007454272504",
                          "549043809916080", "962410809534811", "445893523733475", "768705303214174", "650629270887160"};
        String[] case2Pattern = {"99", "99"};
        System.out.println(GridSearch.gridSearch(case2, case2Pattern));

        // case 3
        String[] case3 = {"7283455864", "6731158619", "8988242643", "3830589324", "2229505813",
                          "5633845374", "6473530293", "7053106601", "0834282956", "4607924137"};

        String[] case3Pattern = {"9505", "3845", "3530"};
        System.out.println(GridSearch.gridSearch(case3, case3Pattern));

        // case 4 - yes
        String[] case4 = {"999999", "121211"};
        String[] case4Pattern = {"99", "11"};
        System.out.println(GridSearch.gridSearch(case4, case4Pattern));
    }

    @Test
    public void testAbsolutePermutation() {
	    // case 1: 2 1
        int n = 2;
        int k = 1;
        int[] result = AbsolutePermutation.absolutePermutation(n, k);
        System.out.println(Arrays.toString(result));

        // case 2: 3 0
        result = AbsolutePermutation.absolutePermutation(3, 0);
        System.out.println(Arrays.toString(result));

        // case 3: 3 2
        result = AbsolutePermutation.absolutePermutation(3, 2);
        System.out.println(Arrays.toString(result));

    }

    @Test
    public void testBomberMan() {
        String[] grid = {"...", ".O.", "..."};
        System.out.println(Arrays.toString(BomberMan.bomberMan(3, grid)));

        String[] secondCase = {".......", "...O...", "....O..", ".......", "OO.....", "OO....."};
        System.out.println(Arrays.toString(BomberMan.bomberMan(3, secondCase)));
    }
}
