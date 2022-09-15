
# myWbeLearn
开启新的学习历程

springSecurity 实现登录认证

方式一：
    利用jwt拦截器，拦截具有token的请求，将token中的用户信息存储到当前上下文的SecurityContextHolder中，设置带有三个参数的 UsernamePasswordAuthenticationToken
这个含有一个属性 super.setAuthenticated(true); 表示通过验证；
    第二部上述拦截器放行的接口，进行登录验证，交由 UsernamePasswordAuthenticationFilter 的 attemptAuthentication 获取请求中的用户信息进行验证
登录（this.getAuthenticationManager().authenticate(authenticationToken)），接下来会调用到 UserDetailsService 的 loadUserByUsername 通过该方法查询数据库的
用户信息，并且返回，交给框架进行比较；
    验证通过和失败可以在 UsernamePasswordAuthenticationFilter 的 successfulAuthentication 和 unsuccessfulAuthentication ，这部分必须重写，如果继承复用会导致
走框架的后续拦截器，这会导致其他情况发生，比如验证失败，原因：其实是登录成功，但是走后续拦截器，请求会被重定向到 ”/“ 这时候就会验证失败，你可以看登录请求上带状态码 302
    
    方法缺点：
            无法直接访问你需要的登录接口，无法判断登录失败的具体缘由，由于被上述认证成功和失败方法覆盖（具体缘由未有时间处理，有待学习）；

    注意点：
        所有继承实现的拦截器加入 springSecurity 配置类中，springSecurity 的配置不拦截无效，因为这是注入进 spring 中的拦截器。springSecurity 中的配置只针对springSecurity
本身的过滤器和拦截器。所以 anonymous() 和 permitAll() 只对 springSecurity 框架自带的拦截器和过滤器有效。

方式二：
    允许 /login 接口直接访问到，然后下一步直接进入登录验证
    对于捕捉不了“用户名不存在的问题”我们重新注入 SpringSecurity 的验证中心，设置属性 setHideUserNotFoundExceptions(false); 这样就能捕捉到
用户名不存在异常的问题。
    最后通过全局异常捕捉，新的自定义认证异常，返回给前端用户认证的异常信息。
    对于其他的请求，通过解析登录之后存储在 redis 的 token 信息，存储入上下文的SecurityContextHolder中，用于权限认证和保存登录信息，同时继承实现
了 SpringSecurity 的俩个认证失败和无权限的 handler 类，用于返回异常。

