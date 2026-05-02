import markdown
from fpdf import FPDF

# Read Markdown
md_path = "C:/Users/kumat/.gemini/antigravity/brain/4eccaac7-15e8-4255-ab16-468036f9dc05/approach.md"
with open(md_path, "r", encoding="utf-8") as f:
    md_text = f.read()

# Convert Markdown to HTML
html_content = markdown.markdown(md_text)

# Initialize PDF
pdf = FPDF()
pdf.add_page()
# FPDF2 supports default font for HTML
pdf.set_font("Times", size=12)

# FPDF2 requires HTML to be written properly, write_html parses basic html tags
try:
    pdf.write_html(html_content)
    pdf.output("C:/Users/kumat/.gemini/antigravity/scratch/library-management/Project_Submission.pdf")
    print("PDF generated successfully.")
except Exception as e:
    print(f"Error generating PDF: {e}")
