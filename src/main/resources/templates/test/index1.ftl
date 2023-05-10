<!DOCTYPE html>
<html lang="en">
    <head>
      <meta charset="UTF-8">
      <title>Title</title>
    </head>
  <body>

  <h1>Заголовок</h1>
  <h3>Заголовок</h3>
  <h1>Заголовок</h1>
  <h1>Заголовок</h1>
  <h20>Заголовок</h20>
  <h1>Заголовок</h1>
  <h2>Заголовок</h2>
  <h1>Заголовок</h1>

  <p>asdasd asdasd <b>asd</b> asd <i>asd</i> assd dsd sd</p>

  <h2>Список</h2>
  <ul>
    <li>c#</li>
    <li>Java</li>
    <li>JavaScript</li>

  </ul>
  <table>

    <tr>
      <th>FirstName </th>
      <th>LastName </th>
      <th>Age </th>
      <th>Email </th>
    <tbody>
    </tr>
    <tr>
      <td>Vasia </td>
      <td>Pupkin </td>
      <td>28 </td>
      <td>kukri@gmail.com </td>
    </tr>
    </tbody>



  </table>
  <h2>Select</h2>
  <select name="job" >
    <option value="student">student</option>
    <option value="teacher">Teacher</option>
    <option value="developer">Developer</option>
    </select>

  <h2>Select Multiple</h2>
<select name="jasdf" multiple size="3">
  <option value="student">student</option>
  <option value="teacher">Teacher</option>
  <option value="developer">Developer</option>
</select>

  <h2>Select</h2>
  <input type="radio" name="garder" value="f">Жінка</input>
  <input type="radio" name="garder" value="m">Чоловік</input>




<h2>Текстові поля для вводу</h2>
  <label for="name">Username</label>
  <input type="text" id="name" name="name" placeholder="Write her">
  <label for="password">Password</label>
  <input type="text" id="password" name="password" placeholder="Write her">
  <label for="password2">Password2</label>
  <input type="password" id="password2" name="password2" placeholder="password vvedi">
<h2>Кнопки</h2>
  <input type="submit" name="knopka" value="dobav">
  <button type="submit">add</button>


  <h2>Приклад</h2>

  <form action="/login" method="get">
    <label for="name">Username</label>
    <input type="text" id="name" name="name" placeholder="Write her"><br>
    <label for="password2">Password2</label>
    <input type="password" id="password2" name="password2" placeholder="Write her">
    <input type="submit" name="Log in" value="Log in">
  </form>

  <h2>Приклад2(захищений пароль)</h2>

  <form action="/login" method="post">
    <label for="name">Username</label>
    <input type="text" id="name" name="name" placeholder="Write her"><br>
    <label for="password2">Password2</label>
    <input type="password" id="password2" name="password2" placeholder="Write her">
    <input type="submit" name="Log in" value="Log in">
  </form>
<h2>Картинка</h2>
<img src="../img/fon.png" alt="Рабочий фон">
  <h2>Переходы</h2>
  <a href="/home">go to home</a>
  </body>
</html>