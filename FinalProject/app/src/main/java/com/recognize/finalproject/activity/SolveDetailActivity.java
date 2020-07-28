package com.recognize.finalproject.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.recognize.finalproject.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SolveDetailActivity extends AppCompatActivity {
    // Set the class variable
    String variable;
    String equation; // biến cho phương trình
    LinearLayout wrapper;
    EditText edtEquation;
    TextView txtError;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve_detail);
        // getSupportActionBar().hide();

        addControls();
        getDataIntent();
        // vừa gửi data qua là solve liền
        solve();
    }

    private void addControls() {

        //ActionBar actionBar = getSupportActionBar();
        toolbar = (Toolbar) findViewById(R.id.toolBarDetail);
        toolbar.setTitle("Chi tiết bước giải");
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        actionBar.setTitle("Chi tiết bước giải");
//        actionBar.setDisplayShowHomeEnabled(true);
//        actionBar.setIcon(R.drawable.ic_back);
        wrapper = (LinearLayout) findViewById(R.id.wrapper);
        edtEquation = (EditText) findViewById(R.id.edtEquation);
        txtError = (TextView) findViewById(R.id.txtError);
    }

    // hàm lấy data từ ResultActivity qua để giải từng bước
    private void getDataIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("expression")) {
                edtEquation.setText(intent.getStringExtra("expression"));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.solve_step_by_step_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.solve:
                solve();
                return true;
            case android.R.id.home: // mặc định nút bấm quay lại có id là home
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // hàm giải phương trình bậc 2
    public String equation2(double a, double b, double c) {
        double delta = (b * b) - (4 * a * c);
        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
        return x1 + "" + x2;
    }

    // phương thức để set biến lớp
    public void setClassVariable() {
        // duyệt phương trình (đã xóa các khoảng trắng)
        for (int i = 0; i < equation.length(); i++) {
            // tách từng kí tự i
            char chr = equation.charAt(i);
            // sau đó kiểm tra từng kí tự có phải là chữ cái hay chữ số (VD: A hay 2)
            if (Character.isLetter(chr)) {
                // nếu là ký tự chữ số thì chuyển ký tự thành chuỗi (cộng ký tự vào chuỗi)
                variable = Character.toString(chr);
                return;
            }
        }
        // ngược lại gán variable = none
        variable = "None";
    }

    // Tách biểu thức thành các thành phần của nó ==> trả về mảng các thành phần của phương trình
    // VD: 2x + 6 thành [2x, +6]
    public ArrayList<String> split(String equation) {
        String expression = "";
        ArrayList<String> splitedEquation = new ArrayList();
        boolean isInsideBracket = false;

        // duyệt phương trình (đã cắt các khoảng trắng)
        for (int i = 0; i < equation.length(); i++) {
            // chuyển tất cả kí tự thành chuỗi
            String chr = Character.toString(equation.charAt(i));

            // nếu kí tự là dấu '+' hoặc dấu '-'
            if ((chr.equals("+") || chr.equals("-")) && i != 0 && !isInsideBracket) {
                splitedEquation.add(expression);
                expression = chr;

            } else {
                expression += chr;
            }

            if (chr.equals("(")) {
                isInsideBracket = true;
            } else if (chr.equals(")")) {
                isInsideBracket = false;
            }
        }
        splitedEquation.add(expression);

        return splitedEquation;
    }

    // kiểm tra xem 1 biểu thức có chứa dấu ngoặc không
    public boolean containsBracket(String expression) {
        return expression.contains("(");
    }

    /**
     * It removes and evaluates components with bracket. e.g It turns ['2x', 2(x-8)] to ['2x', '2x', '-8']
     *
     * @param equationComponents equation components
     * @return
     */
    // mở dấu ngoặc và tách thành các thành phần
    public ArrayList<String> openBracket(ArrayList<String> equationComponents) {
        // list các thành phần của phương trình
        ArrayList<String> eqtComponents = new ArrayList<>();
        // duyệt từng thành phần
        for (int i = 0; i < equationComponents.size(); i++) {
            // kiểm tra từng thành phần có chứa dấu '(' không
            if (containsBracket(equationComponents.get(i))) {
                eqtComponents.addAll(expand(equationComponents.get(i)));
            } else {
                eqtComponents.add(equationComponents.get(i));
            }
        }

        return eqtComponents;
    }

    /**
     * It expands an expression with bracket e.g it turns 2(5x-8) => 10x - 16
     *
     * @param expression The expression to expand
     * @return a string with the evaluated form of the expression
     */

    // mở rộng biểu thức trong ngoặc (VD: 2(5x-8) ==> 10x - 16)
    public ArrayList<String> expand(String expression) {
        // tách chuỗi dựa vào dấu (, kết quả trả về là một mảng các chuỗi
        String[] expr = expression.split("[(]");

        int multiplier = expr[0].equals("-") || expr[0].equals("+") ? Integer.parseInt(expr[0] + "1") : Integer.parseInt(expr[0]);
        // kết quả
        ArrayList<String> result = new ArrayList<>();

        ArrayList<String> exprInBracket = split(getExprInBracket(expr[1]));

        for (int i = 0; i < exprInBracket.size(); i++) {
            String elem = exprInBracket.get(i);
            try {
                Integer constant = multiplier * Integer.parseInt(elem);
                result.add(constant.toString());
            } catch (Exception e) {
                Integer newCoefficient = getCoefficient(elem) * multiplier;
                result.add(newCoefficient.toString() + variable);
            }
        }

        return result;
    }

    /**
     * Gets the coefficient of a variable (as the name implies) e.g 2x => 2
     *
     * @param variable
     * @return int the coefficient of the variable
     */

    // hàm lấy hệ số của 1 biến (VD: 2x ==> 2), trả về số lượng hệ số
    public static int getCoefficient(String variable) {
        String coefficient = "";
        // nếu biến có length = 1 ==> 1
        if (variable.length() == 1) return 1;
        // nếu biến có length = 2 (VD: -x) ==> -1
        else if (variable.length() == 2 && variable.charAt(0) == '-') return -1;
        // duyệt biến
        for (int i = 0; i < variable.length(); i++) {
            // nếu là ký tự số thì + 1
            if (Character.isDigit(variable.charAt(i))) coefficient += variable.charAt(i);
        }
        // nếu ký tự đầu tiên của biến là '-' thì lấy luôn dấu '-'
        if (variable.charAt(0) == '-') return Integer.parseInt("-" + coefficient);
        return Integer.parseInt(coefficient);
    }

    public String getExprInBracket(String expr) {
        String exprInBracket = "";
        for (int i = 0; i < expr.length() - 1; i++) {
            exprInBracket += expr.charAt(i);
        }

        return exprInBracket;
    }

    /**
     * It Collect like terms.
     *
     * @param leftHandSide  The left hand side of the equation
     * @param rightHandSide The right hand side of the equation
     * @return Array with variables and constants seperately
     */
    public ArrayList<String>[] collectLikeTerms(ArrayList<String> leftHandSide, ArrayList<String> rightHandSide) {
        ArrayList<String> variables = new ArrayList<>();
        ArrayList<String> constants = new ArrayList<>();

        for (int i = 0; i < leftHandSide.size(); i++) {
            String elem = leftHandSide.get(i);
            try {
                Integer constant = -1 * Integer.parseInt(elem);
                constants.add(constant.toString());
            } catch (Exception e) {
                variables.add(elem);
            }
        }

        for (int j = 0; j < rightHandSide.size(); j++) {
            String elem = rightHandSide.get(j);
            try {
                Integer constant = Integer.parseInt(elem);
                constants.add(constant.toString());
            } catch (Exception e) {
                variables.add(changeVariableSign(elem));
            }
        }

        ArrayList<String>[] result = new ArrayList[2];
        result[0] = variables;
        result[1] = constants;
        return result;
    }

    // phương thức này để thay đổi dấu của 1 biến khi chuyển vế
    public String changeVariableSign(String variable) {
        char firstChar = variable.charAt(0);
        if (Character.toString(firstChar).equals("+")) {
            return variable.replace("+", "-");
        } else if (Character.toString(firstChar).equals("-")) {
            return variable.replace("-", "+");
        } else {
            return "-" + variable;
        }
    }

    // hàm giải từng bước
    public void solve() {
        // ban đầu sẽ xóa LinearLayout đi, mặc định là rỗng
        wrapper.removeAllViews();
        txtError.setText("");
        Integer nextStep = 1;
        equation = edtEquation.getText().toString();
        // xóa tất cả khoảng trắng của phương trình
        equation = equation.replaceAll("\\s+", "");
        setClassVariable();

        if (!isValidEquation()) {
            return;
        }
        displaySteps(equation, "Bước " + nextStep.toString() + ": ", "Xóa khoảng trắng của phương trình");
        nextStep += 1;

        // tách thành 2 phần trái và phải dấu '=' của phương trình
        String[] divEquation = equation.split("=");

        String leftHandSide = divEquation[0]; // phía bên trái của phương trình (bên trái dấu '=')
        String rightHandSide = divEquation[1]; // phía bên phải của phương trình (bên phải dấu '=')
        ArrayList<String> leftHandSideComps = split(leftHandSide); // tách thành từng thành phần bên trái
        ArrayList<String> rightHandSideComps = split(rightHandSide); // tách từng thành phần bên phải

        // nếu phương trình chứa dấu ngoặc ()
        if (containsBracket(equation)) {
            if (containsBracket(leftHandSide)) leftHandSideComps = openBracket(leftHandSideComps);
            if (containsBracket(rightHandSide))
                rightHandSideComps = openBracket(rightHandSideComps);

            displaySteps(getSolution(leftHandSideComps, rightHandSideComps), "Bước " + nextStep.toString() + ": ", "Nhân biểu thức trong dấu ngoặc");
            nextStep += 1;
        }

        ArrayList<String>[] likeTerms = collectLikeTerms(leftHandSideComps, rightHandSideComps);

        leftHandSideComps = likeTerms[0]; // Now holds the variables.
        rightHandSideComps = likeTerms[1]; // Now holds the constants.

        displaySteps(getSolution(leftHandSideComps, rightHandSideComps), "Bước " + nextStep.toString() + ": ", "Chuyển vế và đổi dấu");
        nextStep += 1;

        String variableSum = simplifyExpression(leftHandSideComps);
        String constantSum = simplifyConstants(rightHandSideComps);
        Integer coef = getCoefficient(variableSum);

        displaySteps(variableSum + " = " + constantSum, "Bước " + nextStep.toString() + ": ", "Đơn giản hóa 2 vế của phương trình");


        if (variableSum.equals(variable)) {
            displaySteps("Vậy: " + variable + " = " + constantSum, "Bước " + nextStep.toString() + ": ", "Kết quả cuối cùng");
            return;
        }

        if (coef == -1) {
            constantSum = Integer.toString(Integer.parseInt(constantSum) * -1);
            displaySteps(variable + " = " + constantSum, "Bước " + nextStep.toString() + ": ", "Nhân với -1");
            nextStep += 1;
            displaySteps("Vậy: " + variable + " = " + constantSum, "Bước " + nextStep.toString() + ": ", "Kết quả cuối cùng");
            return;
        }
        float constant = Float.parseFloat(constantSum) / coef;

        DecimalFormat df = new DecimalFormat("0.00");

        displaySteps(variableSum + "/" + coef.toString() + " = " + constantSum + "/" + coef.toString(), "Bước " + nextStep.toString() + ": ", "Chia cả 2 vế của phương trình cho " + coef.toString());

        if (coef == 0) {
            displaySteps("Vậy: " + variable + " = " + "Không xác định", "Bước " + nextStep.toString() + ": ", "Kết quả cuối cùng");
            return;
        }

        displaySteps("Vậy: " + variable + " = " + df.format(constant), "Bước " + nextStep.toString() + ": ", "Kết quả cuối cùng");

    }

    /**
     * Display solution to for each step
     *
     * @param solution The solution for a given step
     * @param step     The step
     * @param content  The step content
     */
    // hiển thị solution cho từng bước
    public void displaySteps(String solution, String step, String content) {
        // màu cho text
        int textColor = Integer.parseInt("000000", 16) + 0xFF000000;

        // ánh xạ LinearLayout
        wrapper = findViewById(R.id.wrapper);
        // wrapper.removeAllViews();
        LinearLayout linearLayout = new LinearLayout(this);
        // step
        TextView stepTextView = new TextView(this);
        // nội dung từng bước
        TextView stepContentTextView = new TextView(this);
        // solution cho từng bước
        TextView solutionTextView = new TextView(this);

        LinearLayout.LayoutParams linearLayouParams = new LinearLayout
                .LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams textParams = new LinearLayout
                .LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        LinearLayout.LayoutParams solutionTextParams = new LinearLayout
                .LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        solutionTextParams.setMargins(40, 18, 0, 0);
        linearLayouParams.setMargins(40, 20, 0, 0);

        stepTextView.setLayoutParams(textParams);
        stepTextView.setText(step);

        stepContentTextView.setLayoutParams(textParams);
        stepContentTextView.setText(content);
        stepContentTextView.setTextSize(17);
        stepContentTextView.setTextColor(textColor);

        stepTextView.setLayoutParams(textParams);
        stepTextView.setText(step);
        stepTextView.setTextSize(17);
        stepTextView.setTextColor(textColor);
        stepTextView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));

        solutionTextView.setLayoutParams(solutionTextParams);
        solutionTextView.setText(solution);
        solutionTextView.setTextSize(17);
        solutionTextView.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
        solutionTextView.setTextColor(textColor);

        linearLayout.setLayoutParams(linearLayouParams);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.addView(stepTextView);
        linearLayout.addView(stepContentTextView);
        wrapper.addView(linearLayout);
        wrapper.addView(solutionTextView);

    }

    /**
     * It merges the right and left hand side of the equation components
     *
     * @param leftHandSide(List)  The left hand side of the equation in a list
     * @param rightHandSide(List) Contains the components on the right hand side of the equation in a list
     * @return String The string that contain the simplified equation
     */
    public String getSolution(ArrayList<String> leftHandSide, ArrayList<String> rightHandSide) {
        String leftHandSideSolution = "";
        String rightHandSideSolution = "";
        System.out.println(leftHandSide);

        for (int i = 0; i < leftHandSide.size(); i++) {
            if (i == 0) {
                leftHandSideSolution = leftHandSide.get(0);
            } else {
                leftHandSideSolution = leftHandSideSolution + " " + getSolutionVar(leftHandSide.get(i));
            }
        }

        for (int i = 0; i < rightHandSide.size(); i++) {
            if (i == 0) {
                rightHandSideSolution = rightHandSide.get(0);
            } else {
                rightHandSideSolution = rightHandSideSolution + " " + getSolutionVar(rightHandSide.get(i));
            }
        }
        return leftHandSideSolution + " = " + rightHandSideSolution;
    }

    public String getSolutionVar(String var) {
        char firstChar = var.charAt(0);
        if (Character.toString(firstChar).equals("+")) {
            return var.replace("+", "+ ");
        } else if (Character.toString(firstChar).equals("-")) {
            return var.replace("-", "- ");
        } else {
            return "+ " + var;
        }
    }

    /**
     * It simplify an expression. eg from [2x, +3x] into 5x
     *
     * @param expression The components in of an expression in an array e.g [2x, 4x, -5x]
     * @return String that holds the simplified expression
     */
    public String simplifyExpression(ArrayList<String> expression) {
        Integer coefficient = 0;
        for (int i = 0; i < expression.size(); i++) {
            coefficient += getCoefficient(expression.get(i));
        }

        if (coefficient == 1) return variable;
        if (coefficient == -1) return "-" + variable;

        return coefficient.toString(coefficient) + variable;
    }

    /**
     * Add up all the constants
     *
     * @param constants ArrayList of constants
     * @return
     */

    public String simplifyConstants(ArrayList<String> constants) {

        Integer constantSum = 0;
        for (int i = 0; i < constants.size(); i++) {
            constantSum += Integer.parseInt(constants.get(i));
        }

        return constantSum.toString();
    }

    // hàm kiểm tra sự hơp lệ của phương trình
    public boolean isValidEquation() {
        String sign = "";  //this store the sign
        int ovar = 0;
        String num = "";

        if (equation.length() == 0) {
            txtError.setText("Bạn chưa nhập biểu thức!");
            return false;
        }

        if (variable.equals("None")) {
            txtError.setText("Phương trình không hợp lệ! Không có biến.");
            return false;
        }

        if (!equation.contains("=")) {
            txtError.setText("Phương trình không hợp lệ! Không có dấu '=' trong phương trình của bạn");
            return false;
        }

        //Checking if there is more than one variable and equals sign(=) in the equation
        // kiểm tra nếu nhiều hơn 1 biến và hơn 1 dấu '='
        int numOfEqualitySign = 0;
        for (int j = 0; j < equation.length(); j++) {
            if (equation.charAt(j) == '=') {
                numOfEqualitySign += 1;
                if (numOfEqualitySign > 1) {
                    txtError.setText("Phương trình không hợp lệ! Bạn có nhiều hơn một dấu '=' trong phương trình của bạn");
                    return false;
                }
                numOfEqualitySign += 1;
            }

            if (Character.isLetter(equation.charAt(j)) && !Character.toString(equation.charAt(j)).equals(variable)) {
                txtError.setText("c");
                return false;
            }
        }

        if (equation.charAt(equation.length() - 1) == '=') {
            txtError.setText("Phương trình không hợp lệ! Bạn đã không nhập bất cứ thứ gì sau dấu '='");
            return false;

        } else if (equation.charAt(0) == '=') {
            txtError.setText("Phương trình không hợp lệ! Bạn đã không nhập bất cứ thứ gì trước dấu '='");
            return false;
        }

        //checking if the equation ends with either + or - Or two or more signs come together
        for (int k = 0; k < equation.length(); k++) {
            if ((equation.charAt(0) == '+' && equation.charAt(1) == '=') || (equation.charAt(0) == '-' && equation.charAt(1) == '=')) {
                System.out.println("Phương trình không hợp lệ! Chỉ sai khi " + equation.charAt(0) + " ở phía bên trái của phương trình");
                return true;
            }
            if (equation.charAt(k) == '-' || equation.charAt(k) == '+') {
                sign = "" + equation.charAt(k);
                if (k == equation.length() - 1) {
                    System.out.println("Phương trình không hợp lệ! Bạn không thể kết thúc phương trình với " + sign);
                    return true;
                } else if (equation.charAt(k + 1) == '+' || equation.charAt(k + 1) == '-') {

                    txtError.setText("Phương trình không hợp lệ! Hai hay nhiều dấu (+,-) không thể cạnh nhau.");
                    return true;
                }
            }
            if (Character.isLetter(equation.charAt(k))) {
                if (k != equation.length() - 1) {

                    if (Character.isLetter(equation.charAt(k + 1))) {
                        txtError.setText("Phương trình không hợp lệ! Hai hoặc nhiều biến không thể nằm cùng nhau. ");
                        return false;
                    }
                }
            }
            if (k != equation.length() - 1) {
                if (Character.isLetter(equation.charAt(k)) && Character.isDigit(equation.charAt(k + 1))) {
                    txtError.setText("Phương trình không hợp lệ! You are expected to input either \"+\" or \"-\"  sign after " + equation.charAt(k) + " but you input " + equation.charAt(k + 1) + " which is a number");
                    return false;
                }
            }
            if (equation.charAt(k) == '(' || equation.charAt(k) == ')') {
                sign = "" + equation.charAt(k);
                if (k != equation.length() - 1) {
                    if (equation.charAt(k + 1) == '(' || equation.charAt(k + 1) == ')') {
                        txtError.setText("Invalid equation! You cant have two or more " + sign + " together");
                        return false;
                    }
                }
            }
        }

        for (int m = 0; m < equation.length(); m++) {
            if (equation.charAt(m) == '(') ovar += 1;
            else if (equation.charAt(m) == ')') ovar -= 1;
            if (ovar > 1) {
                txtError.setText("Invalid equation! You are expected to put a close bracket \")\" after " + equation.charAt(m - 1) + " not an open bracket \"(\" ");
                return false;
            } else if (ovar < 0) {
                txtError.setText("Invalid equation! You are expected to put a open bracket \"(\" after " + equation.charAt(m - 1) + " not a close bracket \") \" ");
                return false;
            }

        }
        if (ovar == 1) {
            txtError.setText("Invalid equation! You didnt close a bracket you opened.");
            return false;
        }
        String hold = "";

        //making sure that the factorize number has nno variable;
        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == '(') {
                // check1= 0;
                // making the variable hold empty after each passing
                hold = "";
                // the variable j tells if the open bracket is the first element in the string and also try to get the first number in num.
                int j = i - 1;

                int k = i + 1;
                //trying to get the number that is used to multily everything in the bracket and assign it to the variable num
                if (j >= 0) {
                    while (Character.isDigit(equation.charAt(j)) || Character.isLetter(equation.charAt(j))) {
                        num = num + equation.charAt(j);
                        j -= 1;
                        if (j < 0) break;
                    }
                }

                while (equation.charAt(k) != ')') {
                    hold = hold + equation.charAt(k);
                    k += 1;
                }
                for (int q = 0; q < num.length(); q++) {
                    if (Character.isLetter(num.charAt(q))) {
                        txtError.setText("Invalid equation! You are not allowed to open a bracket with a variable");
                        return false;
                    }
                }
                for (int q = 0; q < hold.length(); q++) {
                    if (hold.charAt(q) == '=') {
                        txtError.setText("Invalid equation! It does not make sense to have an equality sign inside a bracket");
                        return false;
                    }
                    if (hold.length() == 1) {
                        if (hold.charAt(q) == '+' || hold.charAt(q) == '-') {
                            // TextView textView = findViewById(R.id.);
                            txtError.setText("Invalid equation! It is wrong to have only " + hold.charAt(q) + " in a bracket");
                            return false;
                        }
                    }
                }
                num = "";
            }
        }
        return true;
    }

}
