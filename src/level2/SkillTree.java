package level2;

/*
선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때, 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.

제한 조건
스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
스킬 순서와 스킬트리는 문자열로 표기합니다.
예를 들어, C → B → D 라면 CBD로 표기합니다
선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
skill_trees는 길이 1 이상 20 이하인 배열입니다.
skill_trees의 원소는 스킬을 나타내는 문자열입니다.
skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.

입출력 예 설명
BACDE: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트립니다.
CBADF: 가능한 스킬트리입니다.
AECB: 가능한 스킬트리입니다.
BDA: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트리입니다.

 */

public class SkillTree {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            for(String j : skill_trees){
                boolean check = true;
                int before = j.indexOf(skill.charAt(0));
                for(int i = 1 ; i < skill.length() ; i++){
                    int now = j.indexOf(skill.charAt(i));
                    if((now != -1 && now < before )|| (before == -1 && now > before)){check = false; break;}
                    before = now ;
                }
                if(check){answer ++;}
            }
            return answer;
        }

    public static void main(String[] args) {
        SkillTree skillTree = new SkillTree();
        System.out.println(skillTree.solution("CBD",new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}
