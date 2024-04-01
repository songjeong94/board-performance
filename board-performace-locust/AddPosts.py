from locust import HttpUser, task, between
import random

class AddPosts(HttpUser):
    wait_time = between(1, 2)
    
    def on_start(self):
        self.client.post("/users/sign-in", json={"userId" : "song3",
                                                 "password" : "1234"})
        
        
    @task
    def add_post(self):
        self.client.post("/posts", json= {
            "name" : "테스트 게시글" + str(random.randint(1, 100000)),
            "contents" : "테스트 컨텐츠" + str(random.randint(1, 100000)),
            "categoryId" : random.randint(1, 7),
            "fileId" : random.randint(1, 10)
        })