package org.example.homework;

import java.util.*;
import java.util.stream.Collectors;
import org.example.homework.CourseResult.StudentsResult;

public class Main {

    public static void main(String[] args) {

        List<Student> students = List.of(
                new Student("Ivan4", "Petrov4", 2, List.of(4, 1, 5, 3, 2)),
                new Student("Ivan2", "Petrov2", 2, List.of(4, 3, 2, 3, 2)),
                new Student("Ivan3", "Petrov3", 3, List.of(4, 3, 2, 2, 3)),
                new Student("Ivan1", "Petrov1", 3, List.of(4, 3, 5, 3, 5)),
                new Student("Ivan5", "Petrov5", 1, List.of(4, 3, 4))
        );

        Map<Integer, CourseResult> collect = students.stream()
                //Фильтр студентов. Берутся студенту с количеством оценок больше 3.
                .filter(student -> student.getMarks().size() > 3)
                .collect(Collectors.toMap(
                        Student::getNumberSeason,
                        student -> {
                            //Добавление значения в Map
                            List<StudentsResult> studentsResultList = new ArrayList<>();
                            studentsResultList.add(new StudentsResult(student.getName(), student.getLastname()));
                            return new CourseResult(student.getMarks().stream().mapToInt(Integer::intValue).average().getAsDouble(), studentsResultList);
                        },
                        (existingCourseResult, newCourseResult) -> {
                            //Обработка дубликатов ключей в Map
                            double average = existingCourseResult.getResultByCourse();
                            average = (average + newCourseResult.getResultByCourse()) / 2;
                            existingCourseResult.setResultByCourse(average);
                            existingCourseResult.getStudentsResultList().addAll(newCourseResult.getStudentsResultList());
                            //Сортировка листа студентов
                            existingCourseResult.getStudentsResultList().sort(Comparator.comparing(StudentsResult::getName).thenComparing(StudentsResult::getLastname));
                            return existingCourseResult;
                        },
                        LinkedHashMap::new
                ));

        //Вывод результатов
        collect.entrySet().forEach(entry -> {
            System.out.println("Сезон: " + entry.getKey());
            CourseResult courseResult = entry.getValue();
            System.out.println("Средний балл: " + courseResult.getResultByCourse());
            System.out.println("Студенты:");
            courseResult.getStudentsResultList().forEach(student -> {
                System.out.println("- " + student.getName() + " " + student.getLastname());
            });
            System.out.println("----------------------");
        });
    }
}
