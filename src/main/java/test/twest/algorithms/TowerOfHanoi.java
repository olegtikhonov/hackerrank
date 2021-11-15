package test.twest.algorithms;

/**
 * At the beginning of time, the Hindu temple priests were given a stack of 64 fragile disks of gold and they had the
 * task of transferring the disks from one pole in the ground of the temple to the third pole on the other side of the temple,
 * one disk at a time. No two disks were the same size: each one was a little smaller than the one beneath it; therefore,
 * the largest disk was on the bottom of the pile and the smallest disk was on the top of the pile. The only important rule was that,
 * because the disks were so fragile, a larger disk was to never be placed on a smaller disk, and there was only one intermediate
 * pole where the disks could be temporarily placed (mathforum).  The priests worked day and night to complete the task, and when they did,
 * legend has it that the temple crumbled into dust, and the world vanished before the priests could complete the task,
 * but no one knows if this actually occurred.
 *
 * @see {link https://towerofhanoi.weebly.com/history--legend.html}
 */
public class TowerOfHanoi {
    public static void towerOfHanoi(int disks, char fromRod, char toRod, char auxRod) {
        // stop case
        if(disks == 1) {
            System.out.println(String.format("Move disk 1 from %s to %s", fromRod, toRod));
            return;
        }
        // recursion step
        towerOfHanoi(disks - 1, fromRod, auxRod, toRod);
        System.out.println(String.format("Move disk %d from %s to %s", disks, fromRod, toRod));
        towerOfHanoi(disks - 1, auxRod, toRod, fromRod);
    }
}
