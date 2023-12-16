import java.util.*;
public class DGA {
    Population population = new Population();
    Indivi fittest;
    Indivi Sfittest;
    int Gcount = 0;
    public static void main(String[] args) {
        Random rn = new Random();
        DGA demo = new DGA();
        demo.population.initializePopulation(10);
        demo.population.CFI();
        System.out.println("Generation: " + demo.Gcount + " Fittest: " + demo.population.fittest);
        while (demo.population.fittest < 5) {
            ++demo.Gcount;
            demo.Select();
            demo.Xover();
            if (rn.nextInt()%7 < 5) {
                demo.Mutate();
            }
            demo.addFittestOffspring();
            demo.population.CFI();
            System.out.println("Generation: " + demo.Gcount + " Fittest: " + demo.population.fittest);
        }
        System.out.println("\nSolution found in generation " + demo.Gcount);
        System.out.println("Fitness: "+demo.population.getFit().fitness);
        System.out.print("Genes: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(demo.population.getFit().genes[i]);
        }
        System.out.println("");

    }
    void Select() {
        fittest = population.getFit();
        Sfittest = population.getSfittest();
    }
    void Xover() {
        Random rn = new Random();
        int XoverPoint = rn.nextInt(population.indiv[0].geneLength);
        for (int i = 0; i < XoverPoint; i++) {
            int temp = fittest.genes[i];
            fittest.genes[i] = Sfittest.genes[i];
            Sfittest.genes[i] = temp;

        }

    }
    void Mutate() {
        Random rn = new Random();
        int MutatePoint = rn.nextInt(population.indiv[0].geneLength);
        if (fittest.genes[MutatePoint] == 0) {
            fittest.genes[MutatePoint] = 1;
        } else {
            fittest.genes[MutatePoint] = 0;
        }
        MutatePoint = rn.nextInt(population.indiv[0].geneLength);
        if (Sfittest.genes[MutatePoint] == 0) {
            Sfittest.genes[MutatePoint] = 1;
        } else {
            Sfittest.genes[MutatePoint] = 0;
        }
    }
    Indivi getFitOffspring() {
        if (fittest.fitness > Sfittest.fitness) {
            return fittest;
        }
        return Sfittest;
    }
    void addFittestOffspring() {
        fittest.calF();
        Sfittest.calF();
        int leastFittestIndex = population.getLeastFittestIndex();
        population.indiv[leastFittestIndex] = getFitOffspring();
    }

}
class Indivi implements Cloneable{
    int fitness = 0;
    int[] genes = new int[5];
    int geneLength = 5;
    public Indivi() {
        Random rn = new Random();
        for (int i = 0; i < genes.length; i++) {
            genes[i] = Math.abs(rn.nextInt() % 2);
        }

        fitness = 0;
    }
    public void calF() {

        fitness = 0;
        for (int i = 0; i < 5; i++) {
            if (genes[i] == 1) {
                ++fitness;
            }
        }
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Indivi Indivi = (Indivi)super.clone();
        Indivi.genes = new int[5];
        for(int i = 0; i < Indivi.genes.length; i++){
            Indivi.genes[i] = this.genes[i];
        }
        return Indivi;
    }
}
class Population {
    int popSize = 10;
    Indivi[] indiv = new Indivi[10];
    int fittest = 0;
    public void initializePopulation(int size) {
        for (int i = 0; i < indiv.length; i++) {
            indiv[i] = new Indivi();
        }
    }
    public Indivi getFit() {
        int maxFit = Integer.MIN_VALUE;
        int maxFitIndex = 0;
        for (int i = 0; i < indiv.length; i++) {
            if (maxFit <= indiv[i].fitness) {
                maxFit = indiv[i].fitness;
                maxFitIndex = i;
            }
        }
        fittest = indiv[maxFitIndex].fitness;
        try {
            return (Indivi) indiv[maxFitIndex].clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Indivi getSfittest() {
        int maxFit1 = 0;
        int maxFit2 = 0;
        for (int i = 0; i < indiv.length; i++) {
            if (indiv[i].fitness > indiv[maxFit1].fitness) {
                maxFit2 = maxFit1;
                maxFit1 = i;
            } else if (indiv[i].fitness > indiv[maxFit2].fitness) {
                maxFit2 = i;
            }
        }
        try {
            return (Indivi) indiv[maxFit2].clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int getLeastFittestIndex() {
        int minFitVal = Integer.MAX_VALUE;
        int minFiti = 0;
        for (int i = 0; i < indiv.length; i++) {
            if (minFitVal >= indiv[i].fitness) {
                minFitVal = indiv[i].fitness;
                minFiti = i;
            }
        }
        return minFiti;
    }
    public void CFI() {

        for (int i = 0; i < indiv.length; i++) {
            indiv[i].calF();
        }
        getFit();
    }

}