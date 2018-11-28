package com.example.libquest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Hanoi {

    private int nbDisques;
    private int nbLoop;

    private Stack<Integer> lastPushed;

    private ArrayList<Stack<Integer> > piles;

    public Hanoi(int nbDisques) {
        this.nbDisques = nbDisques;
        this.lastPushed = null;
        this.piles = new ArrayList<Stack<Integer>>();
        this.piles.add(new Stack<Integer>());
        this.piles.add(new Stack<Integer>());
        this.piles.add(new Stack<Integer>());
        this.nbLoop = 0;
        IntStream.range(0, nbDisques).forEach(e->piles.get(0).push(new Integer(nbDisques-e)));
    }

    @Override
    public String toString() {
        return "Hanoi{" +
                " piles : " + piles +
                " nb loop : "+ nbLoop +
                '}';
    }

    /**
     * Retourne la liste de piles non vides ordonnée sur la taille du dernier disque ajouté (ordre décroissant).
     * La dernière pile sur laquelle un élément a été ajouté est exclue.
     * @return List<Stack<Integer>>
     */
    public List<Stack<Integer>> stackByLastElement(){
        return piles.stream()
                .filter(e -> !e.isEmpty() && e != lastPushed)
                .sorted(Comparator.comparing(Stack::lastElement, Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

    /**
     * Retourne la pile sur laquelle on va devoir enlever un disque
     * @return Stack<Integer>
     */
    public Stack<Integer> poppedStack() {
        List<Stack<Integer>> found = stackByLastElement();
        if (hasEmpty())
            return found.get(0);
        return found.get(found.size() - 1);
    }

    /**
     * Retourne la première pile vide
     * @return Stack<Integer>
     */
    public Stack<Integer> getEmptyStack() {
        return piles.stream().filter(e -> e.isEmpty()).findFirst().get();
    }

    /**
     * Retourne la pile sur laquelle le dernier disque de la pile popped doit être ajouté
     * Règle : trouver la pile ayant comme dernier élément un disque dont la différence avec le disque inséré est impaire,
     * sinon lapremièrepile videtrouvée
     * @param popped
     * @return Stack<Integer>
     */
    public Stack<Integer> pushedStack(Stack<Integer> popped) {
        Optional<Map.Entry<Stack<Integer>, Integer>> myMap = piles.stream()
                .filter(e -> e != popped && !e.isEmpty())
                .collect(Collectors.toMap(Function.identity(), p -> p.lastElement() - popped.lastElement()))
                .entrySet().stream()
                .filter(p -> p.getValue() > 0 && p.getValue() % 2 != 0)
                .min(Comparator.comparingInt(Map.Entry::getValue));

        if(myMap.isPresent()) {
            return myMap.get().getKey();
        } else {
            return getEmptyStack();
        }
    }

    /**
     * Détermine si il existe une pile vide
     * @return
     */
    public boolean hasEmpty() {
        return piles.stream().filter(e -> e.isEmpty()).count() > 0;
    }

    /**
     * Fonction récursive qui déplace les disques
     */
    public void move() {
        if (piles.get(1).size() == this.nbDisques ||
                piles.get(2).size() == this.nbDisques)
            return ;
        Stack<Integer> popped = poppedStack();
        Stack<Integer> pushed = pushedStack(popped);
        pushed.push(popped.pop());
        lastPushed =pushed;
        nbLoop++;
        move();
    }

    public static void main (String... args){
        Hanoi maTour = new Hanoi(8);
        maTour.move();
        System.out.println(maTour);
    }
}

