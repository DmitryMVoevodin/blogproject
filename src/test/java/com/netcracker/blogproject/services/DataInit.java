package com.netcracker.blogproject.services;

import com.netcracker.blogproject.entities.Article;
import com.netcracker.blogproject.entities.Topic;
import com.netcracker.blogproject.entities.User;

import java.util.List;

public class DataInit {

    static void insertIntoList(List<User> users, List<Topic> topics, List<Article> articles) {
        User user;
        user = new User(
                "Матюшин", "Илья", "Борисович",
                "matushin4hs@mail.ru", "+79603455499",
                "matush", "sjj32", "Kalemeo",
                true, true);
        user.setUserId(1);
        users.add(user);

        user = new User(
                "Горохова", "Дарья", "Анатольевна",
                "ghnt@gmail.ru", "+79093435567",
                "goroh", "ddfk33", "Дарьюшка",
                false, true);
        user.setUserId(2);
        users.add(user);

        user = new User(
                "Абрамова", "Светлана", "Александровна",
                "abramram@yandex.ru", "+79026852233",
                "abram", "hhjf1", "GaPa",
                false, true);
        user.setUserId(3);
        users.add(user);

        user = new User(
                "Исаев", "Валерий", "Дмитриевич",
                "isaevv@mail.ru", "+79603511419",
                "isae", "UUhbj3", "dany778598",
                false, true);
        user.setUserId(4);
        users.add(user);

        user = new User(
                "Снегирев", "Михаил", "Андреевич",
                "sneg3@mail.ru", "+79603954400",
                "snegir33", "vvvv1bH", "freeg7",
                false, true);
        user.setUserId(5);
        users.add(user);

        user = new User(
                "Лосев", "Сергей", "Иванович",
                "losev@mail.ru", "+79024829594",
                "losiii", "KjKLk8", "Mimosorc",
                false, true);
        user.setUserId(6);
        users.add(user);

        user = new User(
                "Булкина", "Анна", "Сергеевна",
                "annabul@mail.ru", "+79601156391",
                "abulochka", "adfij89", "Eirine",
                false, true);
        user.setUserId(7);
        users.add(user);

        user = new User(
                "Ковров", "Андрей", "Владимирович",
                "kovrov8893@mail.ru", "+79608884152",
                "kover", "lll5hHj", "panzerek",
                false, true);
        user.setUserId(8);
        users.add(user);

        user = new User(
                "Галкина", "Александра", "Романовна",
                "gal@mail.ru", "+79087564737",
                "galochka", "hhhj1", "SkitiDamone",
                true, true);
        user.setUserId(9);
        users.add(user);

        user = new User(
                "Ластина", "Марина", "Вячеславовна",
                "lastina@mail.ru", "+79605904929",
                "lastina", "kbg2", "Сакурако",
                false, true);
        user.setUserId(10);
        users.add(user);

        user = new User(
                "Петухов", "Валентин", "Владиславович",
                "petuh@mail.ru", "+79601922934",
                "petuhov", "8717bj", "Валентинчик",
                false, true);
        user.setUserId(11);
        users.add(user);


        Topic topic;

        topic = new Topic(
                users.get(3 - 1),
                "Tate no Yuusha no Nariagari",
                "Готовый перевод - Становление Героя Щита. Выпуск активен, перевод активен.");
        topic.setTopicId(1);
        topics.add(topic);

        topic = new Topic(
                users.get(10 - 1),
                "Re: Zero kara Hajimeru Isekai Seikatsu",
                "Готовый перевод - Re: Жизнь в альтернативном мире с нуля. Выпуск активен, перевод активен.");
        topic.setTopicId(2);
        topics.add(topic);

        topic = new Topic(
                users.get(6 - 1),
                "Mahouka Koukou no Rettousei",
                "Готовый перевод - Непутевый ученик в школе магии. Выпуск активен, перевод активен.");
        topic.setTopicId(3);
        topics.add(topic);

        topic = new Topic(
                users.get(8 - 1),
                "Spice and Wolf",
                "Готовый перевод - Волчица и пряности. Выпуск активен, перевод активен.");
        topic.setTopicId(4);
        topics.add(topic);

        topic = new Topic(
                users.get(3 - 1),
                "Sword Art Online",
                "Готовый перевод - Мастера меча online. Выпуск активен, перевод активен.");
        topic.setTopicId(5);
        topics.add(topic);


        Article article;

        article = new Article(
                topics.get(1 - 1), users.get(3 - 1),
                "rwc------",
                "Герой щита. Том 1. Глава 1.",
                "Перевел: GaPa",
                "— А?\n" +
                        "Решил я заглянуть в библиотеку неподалёку.\n" +
                        "Я, Иватани Наофуми, студент второго курса местного университета. И я осознаю, что в отличие от сверстников, безнадежно погряз в образе жизни отаку.\n" +
                        "Помню огромное количество аниме, игр и других аспектов этой культуры — и все они гораздо важнее учёбы.");
        article.setArticleId(1);
        articles.add(article);

        article = new Article(
                topics.get(2 - 1), users.get(10 - 1),
                "rwc---r--",
                "ReZero. Арка 4. Глава 78: Голоса его души.",
                "Перевел: Сакурако",
                "Сехмет: Замкнутое в себе, печальное дитя... Ах, так больно смотреть, что я просто не могу больше терпеть... фуф.\n" +
                        "Услышав ее голос, Субару мысленно согласился - он, действительно, выглядел как дитя, который закрылся в себе и упрямо следует к своей цели, никого не слушая. Но его метод надежен - только так он сможет избежать лишних жертв. Повторяя мир и используя бесконечное число возможностей, Субару всегда может продолжать сражаться, принося в жертву свою жизнь. Конечно, в ходе этого его душа будет все черстветь и черстветь, достигая точки невозврата. Но для таких моментов у него уже есть свое оружие, которое позволит ему сохранить себя... нужные слова...");
        article.setArticleId(2);
        articles.add(article);

        article = new Article(
                topics.get(3 - 1), users.get(6 - 1),
                "rwcrwc---",
                "Непутевый ученик в школе магии. Том 5. Воспоминания лета.",
                "Перевел: Mimosorc",
                "Настало 31 августа 2095 года. Для учеников старших школ магии сегодня был последний день летних каникул, что было средним по сравнению с остальными школами: большинство научных и литературных старших школ уже начали новый учебный год, а старшие спортивные школы и школы искусств не начнут к середине сентября. Турнир девяти школ, проходивший с третьего по двенадцатое августа, уже закончился, но для его представителей не было особого дополнительного перерыва.");
        article.setArticleId(3);
        articles.add(article);

        article = new Article(
                topics.get(4 - 1), users.get(8 - 1),
                "rwcrwc---",
                "Волчица и пряности. Том 1. Пролог.",
                "Перевел: panzerek",
                "В этой деревне, когда спелая пшеница колышется на ветру, говорят: вот бежит Волчица.\n" +
                        "Это из-за того, что в волнах колышущейся пшеницы селянам чудятся тени бегущих волков.\n" +
                        "А когда ветер слишком силен и стебли пшеницы прибивает к земле, говорят: их потоптала Волчица.\n" +
                        "Когда случается неурожай, говорят: весь хлеб съела Волчица.\n" +
                        "При кажущемся благополучии трудности, похоже, все-таки встречаются, как изъяны в драгоценных камнях.");
        article.setArticleId(4);
        articles.add(article);

        article = new Article(
                topics.get(2 - 1), users.get(3 - 1),
                "rwc---rwc",
                "ReZero. Арка 4. Глава 100: Сокрытые воспоминания.",
                "Перевел: GaPa",
                "Если он будет искать вслепую, то далеко не продвинется. К такому выводу Субару пришел, когда пробежался вокруг деревни в поисках Льюис, тяжело задыхаясь.\n" +
                        "Субару: Хааа... хааа...\n" +
                        "Оперев на колени руки и судорожно тряся плечами, Субару пытался вдыхать кислород. Усталость в течение нескольких предыдущих дней давала свое - ноги были ватными. Даже дышать ему было больно.\n" +
                        "Отто: Вы в порядке, Нацуки? Если честно, вы так быстро выдыхаетесь.\n" +
                        "Субару: Иди... ты... Я тут вспомнил... что вообще-то сейчас должен был спокойно лечиться... так что, со всеми нынешними проблемами мое состояние находится на пределе...\n" +
                        "Отто: Ладно-ладно, хватит жаловаться на судьбу. Посидите немного. Давайте передохнем и подумаем. Я принесу нам воды.");
        article.setArticleId(5);
        articles.add(article);

    }

}
