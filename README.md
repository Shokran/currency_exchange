# currency_exchange

### Реализовать логику обмена валюты для банкомата.

У нас есть банкомат, который принимает валюту и конвертирует в выбранную (будем считать что любого номинала даже 1.45).
##### Доступные валюты:
* RUB
* USD
* EUR

##### Ожидаемый результат:

Введите валюту которую хотите обменять<br/>
RUB<br/>
Введите сумму<br/>
100<br/>
Введите валюту для обмена<br/>
USD<br/>
Немного терпения...<br/>
Вы действительно хотите купить 1.50 $ за 100 Руб. ?<br/>
Введите "y" если согласны, "n" для отмены.<br/>
Вы совершили обмен: Купили 1.50 $ за 100 ₽.<br/>
Хотите обменять еще?<br/>
Введите "y" если согласны, "n" для отмены.<br/>

##### Подсказки:
Курс валюты, вы можете установить сами.<br/>
Конвертировать валюту саму в себя нельзя.<br/>
Округлять результат обмена до 2х символов.<br/>
Валюта которую вводит пользователь должна существовать (RUB, USD, EUR).<br/>
Для вывода суммы использовать знак валюты ($ и тд)<br/>

### Способ решения:
Для хранения информации по валюте,<br/>
решил создать интерфейс и несколько классов валют<br/>
имплементирующих этот интерфейс

Важным фактором является то,<br/>
что валюты не хранят в себе значения собственного курса.<br/>
Сделано это из соображения того,<br/>
что она не должна знать о себе эти данные.<br/>
Данный вариант реализации дает гибкость в том,<br/>
что если мы захотим сменить курс каждый класс переписывать не нужно,<br/>
или если захотим ввести в одном банкомате несколько курсов валют<br/>
(как если бы в одном банкомате можно было обменять деньги<br/>
у двух или болеее банков) это нам не составит труда.

В ведении курса для облегчения задачи<br/>
решено было использовать класс enum<br/>
прост в использовании и измменении,<br/>
о чем говорилось ранее.

Еще одним важным фактором при решении задачи<br/>
был выбор метода обмена валют.<br/>
В данном случае упрощает жизни следующая идея:<br/>
каждую валюту которую мы хотим обменять,<br/>
сначала мы конвертируюем в доллары,<br/>
а затем меняем доллары в интересующую нас валюту.<br/>
Смысл в данном случае кроется в том, что нам не нужно<br/>
плодить кучу классов конвертации каждой валюты в каждую<br/>
а так же хранить кучу различных валютных курсов<br/>
заменяя это всего лишь одним соотношением доллара к другим валютам.<br/>
С тремя валютами это было бы не слишком наглядно поэтому<br/>
ввел в программе пару дополнительных валют для показательности<br/>
ни методов, ни классов не увиличилось, кроме классов самих валют.

Для сравнения вводимой информации по валюте а также формату ввода<br/>
использовал интересный паттерн называющийся factory,<br/>
удобен в использовании, много места не занимает.<br/>
Тажкже удобен при работе с enum

Много времени ушло на отработку грамотной валидации вводимой суммы.<br/>
На данный момент валидируется на необходимый формат ввода,<br/>
не отрицательность, а также на то, что не является нулем,<br/>
и ввод более двух знаков после запятой.

Не мало важно, что при решении задачи было принято<br/>
отказаться от цифрового формата double и использовать<br/>
более точный формат для работы с деньгами - BigDecimal.

