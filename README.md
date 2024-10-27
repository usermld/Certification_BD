# Итоговая контрольная работа

## Информация о проекте
### Необходимо организовать систему учета для питомника в котором живут домашние и вьючные животные
## Задание:
### 1. Используя команду cat в терминале операционной системы Linux, создать два файла Домашние животные (заполнив файл собаками, кошками, хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и ослы), а затем объединить их. Просмотреть содержимое созданного файла. Переименовать файл, дав ему новое имя (Друзья человека).
### 2. Создать директорию, переместить файл туда.
        cat > 'Home_animals'
        cat > 'Pack_animals'
        mkdir 'Friends_humans'
        mv 'Pack_animals' 'Friends_humans'
        mv 'Home_animals' 'Friends_humans'
        cat 'Home_animals' 'Pack_animals животные' > 'Friends_humans'

### 3. Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.
        wget https://dev.mysql.com/get/mysql-apt-config_0.8.24-1_all.deb
        cd Загрузки sudo dpkg -i mysql-apt-config_0.8.24-1_all.deb
        sudo apt-get update
        sudo apt-get install mysql-server
        systemctl status mysql
### 4. Установить и удалить deb-пакет с помощью dpkg.
        wget https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-j_8.0.32-1ubuntu22.04_all.deb
        mysql-connector-j_8.0.32-1ubuntu22.04_all.deb
        sudo dpkg - i mysql-connector-j_8.0.32-1ubuntu22.04_all.deb
        sudo dpkg -r mysql-connector-j
        sudo apt-get autoremove
### 5. Выложить историю команд в терминале ubuntu
        история находиться в папке images/history
![history](https://github.com/usermld/Certification_BD/blob/master/images/history.png)
### 6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние животные и вьючные животные, в составы которых в случае домашних животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные войдут: Лошади, верблюды и ослы).
        диаграмма находиться в папке images/diagram
![diagram](https://github.com/usermld/Certification_BD/blob/master/images/diagram.png)
### 7. В подключенном MySQL репозитории создать базу данных “Друзья человека”
### 8. Создать таблицы с иерархией из диаграммы в БД
### 9. Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения
### 10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
### 11. Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице
### 12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.
        скрипт 8-12 заданий находиться в папке script.sql
[скрипт](https://github.com/usermld/Certification_BD/blob/master/script.sql)
### 13. Создать класс с Инкапсуляцией методов и наследованием по диаграмме.
### 14. Написать программу, имитирующую работу реестра домашних животных. В программе должен быть реализован следующий функционал:
* Завести новое животное
* определять животное в правильный класс
* увидеть список команд, которое выполняет животное
* обучить животное новым командам
* Реализовать навигацию по меню

        файлы с кодом находяться в файле code
[скрипт](https://github.com/usermld/Certification_BD/blob/master/code)
### 15. Создайте класс Счетчик, у которого есть метод add(), увеличивающий̆ значение внутренней̆int переменной̆на 1 при нажатие “Завести новое животное” Сделайте так, чтобы с объектом такого типа можно было работать в блоке try-with-resources. Нужно бросить исключение, если работа с объектом типа счетчик была не в ресурсном try и/или ресурс остался открыт. Значение считать в ресурсе try, если при заведения животного заполнены все поля.