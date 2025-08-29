@Controller
public class UserController {

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OAuth2User principal) {
        if (principal != null) {
            model.addAttribute("name", principal.getAttribute("name"));
            model.addAttribute("email", principal.getAttribute("email"));
            model.addAttribute("picture", 
                principal.getAttribute("picture") != null ? 
                principal.getAttribute("picture") : 
                principal.getAttribute("avatar_url")); // GitHub fallback
        }
        return "index";
    }
}
