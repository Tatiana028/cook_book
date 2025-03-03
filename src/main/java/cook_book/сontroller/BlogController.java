package cook_book.сontroller;

import cook_book.models.Post;
import cook_book.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String blogModel(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
     }

    @GetMapping("/blog/add")
    public String blogAdd(Model model){
        return "blog-add";
    }

    @GetMapping("/toast-recipe")
    public String blogRecipe(Model model){
        return "toast-recipe-exs";
    }

    @GetMapping("/pasta-recipe")
    public String blogRecipe1(Model model){
        return "pasta-recipe-exs";
    }

    @GetMapping("/crepes-recipe")
    public String blogRecipe2(Model model){
        return "crepes-recipe-exs";
    }

    @PostMapping("/blog/add")
    public String blogAddPost(@RequestParam String title, @RequestParam String full_text,@RequestParam String imageUrl, @RequestParam String ingredients, Model model){
        Post post = new Post(title, full_text, imageUrl, ingredients);
        postRepository.save(post);
        return "redirect:/blog" ;
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id,  Model model){
        if(!postRepository.existsById(id)){
            return "redirect:/blog" ;
        }

        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "blog-details";
    }
}
