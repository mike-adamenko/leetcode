import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@RestController
class HealthcheckController {

    @GetMapping(value = "/healthcheck", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Result> healthcheck(String format) {
        if ("short".equals(format)){
            return  ResponseEntity.ok(new SimpleResult("OK"));
        }
        if ("full".equals(format)){
            return ResponseEntity.ok(new FullResult("OK",  LocalDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"))));
        }
        return ResponseEntity.badRequest().body(null);
    }

    @PutMapping(value = "/healthcheck")
    public ResponseEntity healthcheckPut() {
        return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @PostMapping(value = "/healthcheck")
    public ResponseEntity healthcheckPost() {
        return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);
    }


    @DeleteMapping(value = "/healthcheck")
    public ResponseEntity healthcheckDelete() {
        return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);
    }

    class SimpleResult extends Result{
        String status;

        SimpleResult(String status){
            this.status=status;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    class FullResult extends Result{
        String application;
        String currentTime;

        FullResult(String application, String dateTime){
            this.application=application;
            this.currentTime=dateTime;
        }

        public String getApplication() {
            return application;
        }

        public void setApplication(String application) {
            this.application = application;
        }

        public String getCurrentTime() {
            return currentTime;
        }

        public void setCurrentTime(String currentTime) {
            this.currentTime = currentTime;
        }
    }

    class Result {}

}