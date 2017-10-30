# spring-flux-cats
Demo project for Spring Boot v2.0.0 and Reactive Web

To get Mono<Cat> by id (may be any integer)
<pre>
curl http://localhost:8080/cats/4
</pre>

To subscribe to the Flux<Cat>
<pre>
curl http://localhost:8080/cats
</pre>

For npm version 3: install rxjs
<pre>
npm install @reactivex/rxjs
</pre>