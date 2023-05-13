<#import "/spring.ftl" as spring>
<#import "parts/templ.ftl" as p>

<@p.pages>
    <h1> Registration </h1>

    <form action="/register" method="post">

        <@spring.bind "users"/>

        <label>Username</label><br>
        <@spring.formInput "users.username"/>
        <@spring.showErrors "<br>"/><br>

        <label>Password</label><br>
        <@spring.formInput "users.password"/>
        <@spring.showErrors "<br>"/><br>

        <@spring.bind "client"/>

        <label>First Name</label><br>
        <@spring.formInput "client.firstName"/>
        <@spring.showErrors "<br>"/><br>

        <label>Last Name</label><br>
        <@spring.formInput "client.lastName"/>
        <@spring.showErrors "<br>"/><br>

        <label>Father Name</label><br>
        <@spring.formInput "client.fatherName"/>
        <@spring.showErrors "<br>"/><br>

        <label>Phone</label><br>
        <@spring.formInput "client.phone"/>
        <@spring.showErrors "<br>"/><br>

        <label>Email</label><br>
        <@spring.formInput "client.email"/>
        <@spring.showErrors "<br>"/><br>

        <label>Age</label><br>
        <@spring.formInput "client.age"/>
        <@spring.showErrors "<br>"/><br>

        <input type="submit" value="save">

    </form>

</@p.pages>