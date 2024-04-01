from locust import HttpUser, task, between
import random

# stress test 시나리오
class BoardServer(HttpUser):
    wait_time = between(1, 2)
    
    def on_start(self):
        self.client.post("/users/sign-in", json={"userId" : "song3",
                                                 "password" : "1234"})
    
    @task(3)
    def view_search(self):
        sortStatus = random.choice(["CATEGORIES", "NEWEST", "OLDEST", "HIGHPRICE", "LOWPRICE", "GRADE"])
        categoryId = random.randint(1, 7)
        name = "테스트 게시글".join(str(random.randint(1,10000)))
        headers = {'Content-Type' : 'application/json'}
        data = {"sortStatus" : sortStatus,
                "categoryId" : categoryId,
                "name" : name}
        
        self.client.post("search", json=data, headers=headers)